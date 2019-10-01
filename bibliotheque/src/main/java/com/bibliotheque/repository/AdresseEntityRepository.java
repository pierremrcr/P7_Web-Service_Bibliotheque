package com.bibliotheque.repository;

import com.bibliotheque.entity.AdresseEntity;
import com.bibliotheque.entity.MembreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseEntityRepository extends JpaRepository<AdresseEntity, Integer> {

    List<AdresseEntity> findAll();

    AdresseEntity findById(int id);

    AdresseEntity save(AdresseEntity adresseEntity);

}
