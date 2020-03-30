package com.bibliotheque.repository.repository;

import com.bibliotheque.repository.client.EmpruntClient;
import livres.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpruntRepository {


    @Autowired
    private EmpruntClient client;

    public EmpruntType getEmpruntById(int id) {
        GetEmpruntByIdResponse response = this.client.getEmpruntById(id);
        return response.getEmpruntType();
    }

    public String updateEmprunt(EmpruntType empruntType) {
        UpdateEmpruntResponse response = this.client.updateEmprunt(empruntType);
        return response.getServiceStatus().getStatusCode();
    }

    public String updateRelanceEmprunt(EmpruntType empruntType) {
        UpdateRelanceEmpruntResponse response = this.client.updateRelanceEmprunt(empruntType);
        return response.getServiceStatus().getStatusCode();
    }

    public String updateEmpruntTermine(EmpruntType empruntType) {
        UpdateEmpruntTermineResponse response = this.client.updateEmpruntTermine(empruntType);
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

    public List<EmpruntType> getAllEmpruntsWhereDateFinIsBeforeDateToday() {
        GetAllEmpruntsWhereDateFinIsBeforeDateTodayResponse response = this.client.getAllEmpruntsWhereDateFinIsBeforeDateToday();
        return response.getEmpruntType();
    }

}