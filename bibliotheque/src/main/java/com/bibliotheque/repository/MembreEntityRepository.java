package com.bibliotheque.repository;

import com.bibliotheque.entity.MembreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreEntityRepository extends JpaRepository<MembreEntity, Integer> {

    List<MembreEntity> findAll();

    MembreEntity findById(int id);

    MembreEntity findByNom(String nom);

    MembreEntity save(MembreEntity membreEntity);

    MembreEntity deleteById(int id);


}
