package com.bibliotheque.service;

import com.bibliotheque.repository.repository.ExemplaireRepository;
import com.bibliotheque.repository.repository.LivreRepository;
import com.bibliotheque.repository.repository.MembreRepository;
import livres.wsdl.EmpruntType;
import livres.wsdl.ExemplaireType;
import livres.wsdl.LivreType;
import livres.wsdl.MembreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembreService {

    @Autowired
    private MembreRepository repository;

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Autowired
    private LivreRepository livreRepository;

    public MembreType membreById(int id){

        MembreType membreType = this.repository.membreById(id);

        for (EmpruntType empruntType : membreType.getListeEmprunts()){
            ExemplaireType exemplaireType = exemplaireRepository.exemplaireById(empruntType.getExemplaireid());
            LivreType livreType = livreRepository.livreById(exemplaireType.getLivreid());

        }

        return membreType;
    }

    public String addMembre(MembreType membreType){

        return this.repository.addMembre(membreType);
    }


    public String updateMembre(MembreType membreType) {

        return this.repository.updateMembre(membreType);
    }

    public String deleteMembreById(int id) {

        return this.repository.deleteMembreById(id);
    }
}