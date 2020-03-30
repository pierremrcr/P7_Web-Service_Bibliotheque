package com.bibliotheque.service;

import com.bibliotheque.repository.repository.ExemplaireRepository;
import livres.wsdl.ExemplaireType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemplaireService {

    @Autowired
    private ExemplaireRepository repository;

    public ExemplaireType exemplaireById(int id){

        return this.repository.exemplaireById(id);
    }

    public List<ExemplaireType> getAllExemlaires(){

        return this.repository.getAllExemplaires();
    }

    public List<ExemplaireType> getAllExemlairesAndEmprunts(){

        return this.repository.getAllExemplairesAndEmprunts();
    }
}
