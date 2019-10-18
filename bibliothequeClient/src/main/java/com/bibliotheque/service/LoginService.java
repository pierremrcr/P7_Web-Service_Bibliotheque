package com.bibliotheque.service;

import com.bibliotheque.repository.repository.LoginRepository;
import livres.wsdl.MembreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    public MembreType login(String mail, String motDePasse){

        return this.repository.loginCompte(mail, motDePasse);
    }




}
