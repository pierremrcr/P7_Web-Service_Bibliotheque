package com.bibliotheque.service.impl;

import com.bibliotheque.entity.EmpruntEntity;
import com.bibliotheque.entity.MembreEntity;
import com.bibliotheque.repository.MembreEntityRepository;
import com.bibliotheque.service.contract.MembreEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MembreEntityServiceImpl implements MembreEntityService {

    @Autowired
    private MembreEntityRepository repository;

    public MembreEntityServiceImpl() {

    }

    @Override
    public MembreEntity getMembreById(int id) {

        return this.repository.findById(id);
    }

    @Override
    public MembreEntity getMembreByNom(String nom) {

        return this.repository.findByNom(nom);
    }

    @Override
    public List<MembreEntity> getAllMembres() {
        List<MembreEntity> listeMembres = new ArrayList<>();
        this.repository.findAll().forEach(membreEntity -> listeMembres.add(membreEntity));
        return listeMembres;
    }

    @Override
    public MembreEntity addMembre(MembreEntity membreEntity) {
        try {
            return this.repository.save(membreEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public boolean updateMembre(MembreEntity membreEntity) {
        try {
            this.repository.save(membreEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteMembreById(int id) {
        try {
            MembreEntity membre = this.repository.findById(id);
            for(EmpruntEntity entity : membre.getListeEmprunts()){
                entity.getExemplaireEntity().setDisponibilite(true);
            }
            this.repository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
