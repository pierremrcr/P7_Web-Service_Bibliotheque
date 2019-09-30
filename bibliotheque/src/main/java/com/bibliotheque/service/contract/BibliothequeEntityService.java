package com.bibliotheque.service.contract;

import com.bibliotheque.entity.BibliothequeEntity;

import java.util.List;

public interface BibliothequeEntityService {

    public BibliothequeEntity getBibliothequeById(int id);
    public List<BibliothequeEntity> getAllBibliotheques();
    public BibliothequeEntity addBibliotheque(BibliothequeEntity bibliotheque);
    public boolean updateBibliotheque(BibliothequeEntity bibliotheque);
    public boolean deleteBibliothequeById(int id);


}
