package com.bibliotheque.service;

import com.bibliotheque.repository.repository.MembreRepository;
import livres.wsdl.EmpruntType;
import livres.wsdl.MembreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MembreService {

    @Autowired
    private MembreRepository repository;

    public MembreType membreById(int id){

        return this.repository.membreById(id);
    }

    public String addMembre(MembreType membreType){

        return this.repository.addMembre(membreType);
    }





}
