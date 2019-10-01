package com.bibliotheque.service.contract;

import com.bibliotheque.entity.AdresseEntity;

import java.util.List;

public interface AdresseEntityService {

    public AdresseEntity getAdresseById(int id);
    public List<AdresseEntity> getAllAdresses();
    public AdresseEntity addAdresse(AdresseEntity adresse);
    public boolean updateAdresse(AdresseEntity adresse);
    public boolean deleteAdresseById(int id);


}
