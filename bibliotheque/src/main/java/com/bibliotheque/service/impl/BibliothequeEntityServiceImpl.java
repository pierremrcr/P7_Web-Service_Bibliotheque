package com.bibliotheque.service.impl;

import com.bibliotheque.entity.BibliothequeEntity;
import com.bibliotheque.repository.BibliothequeEntityRepository;
import com.bibliotheque.service.contract.BibliothequeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BibliothequeEntityServiceImpl implements BibliothequeEntityService {

    @Autowired
    private BibliothequeEntityRepository bibliothequeRepository;

    public BibliothequeEntityServiceImpl(){

    }

    @Override
    public BibliothequeEntity getBibliothequeById(int id) {

        return this.bibliothequeRepository.findById(id);
    }

    @Override
    public List<BibliothequeEntity> getAllBibliotheques() {
        List<BibliothequeEntity> listeBibliotheques = new ArrayList<>();
        this.bibliothequeRepository.findAll().forEach(bibliothequeEntity -> listeBibliotheques.add(bibliothequeEntity));
        return listeBibliotheques;
    }


    @Override
    public BibliothequeEntity addBibliotheque(BibliothequeEntity bibliotheque) {
        return null;
    }

    @Override
    public boolean updateBibliotheque(BibliothequeEntity bibliotheque) {
        return true;
    }

    @Override
    public boolean deleteBibliothequeById(int id) {
        return true;
    }
}
