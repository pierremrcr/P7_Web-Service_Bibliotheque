package com.bibliotheque.repository.repository;

import com.bibliotheque.repository.EmpruntClient;
import livres.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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


    public String addEmprunt(EmpruntType empruntType) {
        AddEmpruntResponse response = this.client.addEmprunt(empruntType);
        return response.getServiceStatus().getStatusCode();
    }

    public List<EmpruntType> getAllEmprunts() {
        GetAllEmpruntResponse response = this.client.getAllEmprunts();
        return response.getEmpruntType();
    }
}
