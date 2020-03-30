package com.bibliotheque.repository.repository;

import com.bibliotheque.repository.client.ExemplaireClient;
import livres.wsdl.ExemplaireType;
import livres.wsdl.GetAllExemplairesAndEmpruntsResponse;
import livres.wsdl.GetAllExemplairesResponse;
import livres.wsdl.GetExemplaireByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExemplaireRepository {

    @Autowired
    private ExemplaireClient client;

    public ExemplaireType exemplaireById(int id) {
        GetExemplaireByIdResponse response = this.client.getExemplaireById(id);
        return response.getExemplaireType();
    }

    public List<ExemplaireType> getAllExemplaires() {
        GetAllExemplairesResponse response = this.client.getAllExemplaires();
        return response.getExemplaireType();
    }

    public List<ExemplaireType> getAllExemplairesAndEmprunts() {
        GetAllExemplairesAndEmpruntsResponse response = this.client.getAllExemplairesAndEmprunts();
        return response.getExemplaireType();
    }
}