package com.bibliotheque.repository.repository;

import com.bibliotheque.repository.EmpruntClient;
import livres.wsdl.EmpruntType;
import livres.wsdl.GetEmpruntByIdResponse;
import livres.wsdl.UpdateEmpruntResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpruntRepository {

    @Autowired
    private EmpruntClient client;

    public EmpruntType getEmpruntById(int id){
        GetEmpruntByIdResponse response = this.client.getEmpruntById(id);
        return response.getEmpruntType();
    }

    public String updateEmprunt(EmpruntType empruntType){
        UpdateEmpruntResponse response = this.client.updateEmprunt(empruntType);
        return response.getServiceStatus().getStatusCode();
    }


}
