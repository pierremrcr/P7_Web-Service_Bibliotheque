package com.bibliotheque.repository;

import com.bibliotheque.entity.BibliothequeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BibliothequeEntityRepository extends JpaRepository<BibliothequeEntity, Integer> {

    List<BibliothequeEntity> findAll();

    //BibliothequeEntity findByTitre(String titre);

   BibliothequeEntity findById(int id);

   BibliothequeEntity save(BibliothequeEntity bibliothequeEntity);

}
