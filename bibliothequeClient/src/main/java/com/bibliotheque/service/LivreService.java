package com.bibliotheque.service;

import com.bibliotheque.repository.repository.LivreRepository;
import livres.wsdl.LivreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreRepository repository;

    public LivreType livreById(int id){

        return this.repository.livreById(id);
    }

    public List<LivreType> livreTypeList(){

        return this.repository.livreTypeList();
    }
}
