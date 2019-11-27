package com.bibliotheque.service;

import com.bibliotheque.repository.repository.EmpruntRepository;
import com.bibliotheque.repository.repository.ExemplaireRepository;
import com.bibliotheque.repository.repository.LivreRepository;
import livres.wsdl.EmpruntType;
import livres.wsdl.ExemplaireType;
import livres.wsdl.LivreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class EmpruntService {

    @Autowired
    private EmpruntRepository repository;

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Autowired
    private EmpruntRepository empruntRepository;

    public EmpruntType getEmpruntById(int id){

        return this.repository.getEmpruntById(id);
    }

    public List<ExemplaireType> getAllExemplairesEmpruntes(List<EmpruntType> listeEmprunts){

        List<ExemplaireType> listeExemplaires = new ArrayList<>();

        for(EmpruntType empruntType : listeEmprunts){
            ExemplaireType exemplaireType = exemplaireRepository.exemplaireById(empruntType.getExemplaireid());
            listeExemplaires.add(exemplaireType);
        }

        return listeExemplaires;

    }

    public List<LivreType> getAllLivresEmpruntes(List<ExemplaireType> listeExemplaires){

        List<LivreType> listeLivres = new ArrayList<>();
        List<EmpruntType> listeEmprunts = new ArrayList<>();

        for(ExemplaireType exemplaireType : listeExemplaires) {
            LivreType livreType = livreRepository.livreById(exemplaireType.getLivreid());
            listeLivres.add(livreType);

        }

        return listeLivres;
    }

    public String updateEmprunt(EmpruntType empruntType){

       return this.empruntRepository.updateEmprunt(empruntType);


    }
}
