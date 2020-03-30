package com.bibliotheque.service;

import com.bibliotheque.repository.repository.LoginRepository;
import livres.wsdl.MembreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    public MembreType loginCompte(String mail, String motDePasse) {

        MembreType membreType;

        try {
            membreType = this.repository.loginCompte(mail, motDePasse);
        } catch (Exception e) {
            throw e;
        }

        return membreType;

    }
}
