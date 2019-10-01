package com.bibliotheque.service.impl;

import com.bibliotheque.entity.AdresseEntity;
import com.bibliotheque.repository.AdresseEntityRepository;
import com.bibliotheque.service.contract.AdresseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdresseEntityServiceImpl implements AdresseEntityService {

    @Autowired
    private AdresseEntityRepository repository;

    @Override
    public AdresseEntity getAdresseById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public List<AdresseEntity> getAllAdresses() {
        List<AdresseEntity> listeAdresses = new ArrayList<>();
        this.repository.findAll().forEach(adresseEntity -> listeAdresses.add(adresseEntity));
        return listeAdresses;
    }

    @Override
    public AdresseEntity addAdresse(AdresseEntity adresse) {
        try {
            return this.repository.save(adresse);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateAdresse(AdresseEntity adresse) {
        try {
            this.repository.save(adresse);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAdresseById(int id) {
        try {
            this.repository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
