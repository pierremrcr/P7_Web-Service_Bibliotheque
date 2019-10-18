package com.bibliotheque.repository.repository;

import com.bibliotheque.repository.MembreClient;
import livres.wsdl.AddMembreResponse;
import livres.wsdl.GetMembreByIdResponse;
import livres.wsdl.MembreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembreRepository {

    @Autowired
    private MembreClient client;

    public MembreType membreById(int id){

        GetMembreByIdResponse response = this.client.getMembreById(id);

        return response.getMembreType();

    }

    public String addMembre(MembreType membreType){

        AddMembreResponse response = this.client.addMembre(membreType);

        return response.getServiceStatus().getStatusCode();
    }



}

