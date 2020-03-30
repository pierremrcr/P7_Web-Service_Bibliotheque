package com.bibliotheque.repository.repository;

import com.bibliotheque.repository.client.LoginClient;
import livres.wsdl.GetCompteAfterLoginSuccessResponse;
import livres.wsdl.LoginResponse;
import livres.wsdl.MembreType;
import livres.wsdl.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LoginRepository {

    @Autowired
    private LoginClient client;


    public MembreType loginCompte(String mail, String motDePasse){
        LoginResponse response = this.client.loginCompte(mail, motDePasse);
        return response.getCompteType();
    }

    public Optional<ServiceStatus> login(String mail, String motDePasse){
        LoginResponse response = this.client.loginCompte(mail, motDePasse);
        return Optional.ofNullable(response.getServiceStatus());
    }

    public MembreType getCompteAfterLoginSuccess(String mail){
        GetCompteAfterLoginSuccessResponse response = this.client.getCompteAferLoginSuccess(mail);
        return response.getCompteType();
    }
}
