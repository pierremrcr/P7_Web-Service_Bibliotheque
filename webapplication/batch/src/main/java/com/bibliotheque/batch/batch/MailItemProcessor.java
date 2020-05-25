package com.bibliotheque.batch.batch;

import com.bibliotheque.service.EmpruntService;
import com.bibliotheque.service.ExemplaireService;
import com.bibliotheque.service.LivreService;
import com.bibliotheque.service.MembreService;
import livres.wsdl.EmpruntType;
import livres.wsdl.ExemplaireType;
import livres.wsdl.LivreType;
import livres.wsdl.MembreType;
import com.bibliotheque.batch.mail.SendingMail;
import org.apache.log4j.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class MailItemProcessor implements Tasklet, StepExecutionListener {

    private static final Logger logger = Logger.getLogger(MailItemProcessor.class);

    @Autowired
    private EmpruntService empruntService;

    @Autowired
    private MembreService membreService;

    @Autowired
    private LivreService livreService;

    @Autowired
    private ExemplaireService exemplaireService;

    @Autowired
    private SendingMail sendingMail;

    @Override
    public void beforeStep(StepExecution stepExecution) {


    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {

        return ExitStatus.COMPLETED;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        //On récupère tous les emprunts dont la date de fin de l'emprunt est avant la date d'aujourd'hui et dont l'emprunt n'est pas au statut "terminé"
        List<EmpruntType> listeEmprunts = empruntService.getAllEmpruntsWhereDateFinIsBeforeDateToday();

        logger.info(listeEmprunts.size());

        long joursDeRetard;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        LocalDateTime currentTime = LocalDateTime.now();

        Date dateToDay = dateFormat.parse(dateFormat.format(dateFormat.parse(currentTime.toLocalDate().toString())));

        for (EmpruntType empruntType : listeEmprunts) {

            Date empruntDateFin = dateFormat.parse(dateFormat.format(dateFormat.parse(empruntType.getDateFin().toString())));

            logger.info(empruntDateFin);

            MembreType membreType = membreService.membreById(empruntType.getMembreid());

            ExemplaireType exemplaireType = exemplaireService.exemplaireById(empruntType.getExemplaireid());

            LivreType livreType = livreService.livreById(exemplaireType.getLivreid());

            joursDeRetard = (empruntDateFin.getTime() - dateToDay.getTime()) / (1000 * 60 * 60 * 24);

            String nombreDeJoursStr = String.valueOf(joursDeRetard).replace("-", "");

            String subject = "Restitution du livre : " + livreType.getTitre();

            String text = textMail(membreType, livreType, nombreDeJoursStr);

            sendingMail.sendMessage(subject, text, membreType.getAdresseMail());

            empruntType.setRelance(true);

            empruntService.updateRelanceEmprunt(empruntType);

        }

        return RepeatStatus.FINISHED;
    }



    private String textMail(MembreType membreType, LivreType livreType, String nombreDeJoursStr) {

        return ""
                + "<div style=\"padding-left: 20px\">"
                + "<p>Bonjour, " + membreType.getPrenom() + "</p>"
                + "<p>Vous avez déjà dépassé le délai auquel vous deviez restituer votre emprunt de " + nombreDeJoursStr + " jour(s)!</p>"
                + "<p>Merci de vous rendre à la bibliothèque au plus vite pour nous restituer le livre suivant : </p>"
                + "<p>Titre du livre :  " + livreType.getTitre() + "</p>"
                + "<p>Auteur :  " + livreType.getAuteur() + "</p>"
                + "<p>Merci pour votre compréhension. Cordialement,</p>"
                + "<p>Le personnel de la bibliothèque."
                + "</div>";
    }


}