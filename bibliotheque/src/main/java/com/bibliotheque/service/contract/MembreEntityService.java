package com.bibliotheque.service.contract;

import com.bibliotheque.entity.MembreEntity;

import java.util.List;

public interface MembreEntityService {

    public MembreEntity getMembreById(int id);
    public MembreEntity getMembreByNom(String nom);
    public List<MembreEntity> getAllMembres();
    public MembreEntity addMembre(MembreEntity membreEntity);
    public boolean updateMembre(MembreEntity membreEntity);
    public boolean deleteMembreById(int id);

}
