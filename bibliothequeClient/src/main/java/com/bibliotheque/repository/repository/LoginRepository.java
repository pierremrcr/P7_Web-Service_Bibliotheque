package com.bibliotheque.repository.repository;

import com.bibliotheque.repository.LoginClient;
import livres.wsdl.GetCompteAfterLoginSuccessResponse;
import livres.wsdl.LoginResponse;
import livres.wsdl.MembreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class LoginRepository {

    @Autowired
    private LoginClient client;


    public MembreType loginCompte(String mail, String motDePasse){
        LoginResponse response = this.client.login(mail, motDePasse);
        return response.getCompteType();
    }

    public MembreType getCompteAfterLoginSuccess(String mail){
        GetCompteAfterLoginSuccessResponse response = this.client.getCompteAferLoginSuccess(mail);
        return response.getCompteType();
    }
}
