package com.bibliotheque.service.impl;

import com.bibliotheque.entity.EmpruntEntity;
import com.bibliotheque.repository.EmpruntEntityRepository;
import com.bibliotheque.service.contract.EmpruntEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmpruntEntityServiceImpl implements EmpruntEntityService {

    @Autowired
    EmpruntEntityRepository repository;

    @Override
    public EmpruntEntity getEmpruntById(int id) {

        return this.repository.findById(id);
    }

    @Override
    public List<EmpruntEntity> getAllEmprunts() {
        List<EmpruntEntity> listeEmprunts = new ArrayList<>();
        this.repository.findAll().forEach(empruntEntity -> listeEmprunts.add(empruntEntity));
        return listeEmprunts;
    }

    @Override
    public EmpruntEntity addEmprunt(EmpruntEntity emprunt) {
        try {
            return this.repository.save(emprunt);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateEmprunt(EmpruntEntity emprunt) {
        try {
            this.repository.save(emprunt);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmpruntById(int id) {
        try {
            this.repository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
