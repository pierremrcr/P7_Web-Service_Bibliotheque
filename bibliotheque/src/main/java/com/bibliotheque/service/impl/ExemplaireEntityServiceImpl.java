package com.bibliotheque.service.impl;

import com.bibliotheque.entity.ExemplaireEntity;
import com.bibliotheque.repository.ExemplaireEntityRepository;
import com.bibliotheque.service.contract.ExemplaireEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ExemplaireEntityServiceImpl implements ExemplaireEntityService {

    @Autowired
    ExemplaireEntityRepository repository;


    @Override
    public ExemplaireEntity getExemplaireById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public List<ExemplaireEntity> getAllExemlaires() {
        List<ExemplaireEntity> listeExemplaires = new ArrayList<>();
        this.repository.findAll().forEach(exemplaireEntity -> listeExemplaires.add(exemplaireEntity));
        return listeExemplaires;
    }

    @Override
    public ExemplaireEntity addExemplaire(ExemplaireEntity exemplaireEntity) {
        try {
            return this.repository.save(exemplaireEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteExemplaireById(int id) {
        try {
            this.repository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateExemplaire(ExemplaireEntity exemplaireEntity) {
        try {
            this.repository.save(exemplaireEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ExemplaireEntity> getAllExemplairesAndEmprunts(int id) {
        List<ExemplaireEntity> listeExemplaires = new ArrayList<>();
        this.repository.findAllExemplairesAndEmprunts(id).forEach(exemplaireEntity -> listeExemplaires.add(exemplaireEntity));
        return listeExemplaires;
    }
}
