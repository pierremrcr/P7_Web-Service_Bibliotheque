package com.bibliotheque.web.controller;

import com.bibliotheque.service.EmpruntService;
import com.bibliotheque.service.ExemplaireService;
import com.bibliotheque.service.MembreService;
import livres.wsdl.EmpruntType;
import livres.wsdl.ExemplaireType;
import livres.wsdl.MembreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @Autowired
    private ExemplaireService exemplaireService;

    @Autowired
    private MembreService membreService;


    @RequestMapping(value = "/prolongation", method = RequestMethod.GET)
    public String updateEmprunt(@RequestParam(name = "empruntId") Integer empruntId,
                                HttpSession session) {

        EmpruntType empruntType = empruntService.getEmpruntById(empruntId);

        empruntService.updateEmprunt(empruntType);

        return "ConfirmationProlongation";

    }


    @RequestMapping(value = "/addEmprunt", method = RequestMethod.GET)
    public String doBorrow(@RequestParam(name = "exemplaireId") Integer exemplaireId,
                           @RequestParam(name = "compteId") Integer compteId,
                           Model model,
                           HttpSession session) {

        MembreType membreType = membreService.membreById(compteId);
        EmpruntType empruntType = new EmpruntType();
        ExemplaireType exemplaireType = exemplaireService.exemplaireById(exemplaireId);
        exemplaireType.setDisponibilite(false);
        empruntType.setExemplaireEntity(exemplaireType);
        empruntType.setExemplaireid(exemplaireId);
        empruntType.setMembreid(compteId);
        empruntType.setProlongation(false);
        empruntType.setTermine(false);
        empruntType.setRelance(false);
        empruntType.setMembreEntity(membreType);
        empruntService.addEmprunt(empruntType);

        return "confirmationReservation";

    }

    @RequestMapping(value = "/empruntTermine", method = RequestMethod.GET)
    public String doFinish(@RequestParam(name = "empruntId") Integer empruntId) {

        EmpruntType empruntType = empruntService.getEmpruntById(empruntId);
        empruntType.setTermine(true);
        empruntService.updateEmpruntTermine(empruntType);

        return "home";
    }
}