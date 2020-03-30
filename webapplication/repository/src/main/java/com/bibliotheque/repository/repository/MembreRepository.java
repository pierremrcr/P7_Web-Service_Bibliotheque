package com.bibliotheque.repository.repository;

import com.bibliotheque.repository.client.MembreClient;
import livres.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


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

        public List<MembreType> getAllMembres(){
            GetAllMembresResponse response = this.client.getAllMembres();
            return response.getMembreType();
        }


        public String updateMembre(MembreType membreType) {

            UpdateMembreResponse response = this.client.updateMembre(membreType);

            return response.getServiceStatus().getStatusCode();
        }

        public String deleteMembreById(int id) {

            DeleteMembreResponse response = this.client.deleteMembreById(id);

            return response.getServiceStatus().getStatusCode();
        }
    }



