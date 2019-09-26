package com.bibliotheque.repository;

import com.bibliotheque.entity.LivreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreEntityRepository extends JpaRepository<LivreEntity, Integer > {

    List<LivreEntity> findAll();

    LivreEntity findByTitre(String titre);

    LivreEntity findById(int id);

    LivreEntity save(LivreEntity livreEntity);
}
