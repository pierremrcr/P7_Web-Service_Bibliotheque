package com.bibliotheque.repository.repository;

import com.bibliotheque.repository.client.LivreClient;
import livres.wsdl.GetAllLivresEmpruntesResponse;
import livres.wsdl.GetAllLivresResponse;
import livres.wsdl.GetLivreByIdResponse;
import livres.wsdl.LivreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivreRepository {

    @Autowired
    private LivreClient client;

    public LivreType livreById(int id){
        GetLivreByIdResponse response = this.client.getLivreById(id);
        return response.getLivreType();
    }

    public List<LivreType> livreTypeList() {
        GetAllLivresResponse response = this.client.getAllLivres();
        return response.getLivreType();
    }

    public List<LivreType> getAllLivresEmpruntes(int id){
        GetAllLivresEmpruntesResponse response = this.client.getAllLivresEmpruntes(id);
        return response.getLivreType();
    }

}
