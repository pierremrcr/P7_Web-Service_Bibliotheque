package com.bibliotheque.repository;

import com.bibliotheque.entity.EmpruntEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntEntityRepository extends JpaRepository<EmpruntEntity, Integer> {

    List<EmpruntEntity> findAll();

    EmpruntEntity findById(int id);

    EmpruntEntity save(EmpruntEntity emprunt);
}
