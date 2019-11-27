package com.bibliotheque.service.impl;

import com.bibliotheque.repository.LivreEntityRepository;
import com.bibliotheque.entity.LivreEntity;
import com.bibliotheque.service.contract.LivreEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LivreEntityServiceImpl implements LivreEntityService {

    @Autowired
    private LivreEntityRepository repository;

    public LivreEntityServiceImpl() {
    }

  //  @Autowired
  //  public LivreEntityServiceImpl(LivreEntityRepository repository) {
  //      this.repository = repository;
  //  }


    @Override
    public LivreEntity getLivreById(int id) {

           return this.repository.findById(id);
    }

    @Override
    public LivreEntity getLivreByTitle(String titre) {

        return this.repository.findByTitre(titre);
    }

    @Override
    public List<LivreEntity> getAllLivres() {
        List<LivreEntity> listeLivres = new ArrayList<>();
        this.repository.findAll().forEach(livreEntity -> listeLivres.add(livreEntity));
        return listeLivres;
    }

    @Override
    public LivreEntity addLivre(LivreEntity livreEntity) {
        try{
            return this.repository.save(livreEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateLivre(LivreEntity livreEntity) {
        try {
            this.repository.save(livreEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteLivreById(int id) {
        try {
            this.repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<LivreEntity> getAllLivresByKeyword(String keyword) {
        List<LivreEntity> listeLivres = new ArrayList<>();
        this.repository.findAllLivresByKeyword(keyword).forEach(livreEntity -> listeLivres.add(livreEntity));
        return listeLivres;
    }

    @Override
    public List<LivreEntity> getAllLivreEmpruntesByUser(int id) {
        List<LivreEntity> listeLivres = new ArrayList<>();
        this.repository.findAllLivreEmpruntesByUser(id).forEach(livreEntity -> listeLivres.add(livreEntity));
        return listeLivres;
    }
}


