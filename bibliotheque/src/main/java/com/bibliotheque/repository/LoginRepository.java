package com.bibliotheque.repository;

import com.bibliotheque.entity.MembreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<MembreEntity, Integer> {

    MembreEntity findByAdresseMailAndMotDePasse(String mail, String motDePasse);

    MembreEntity findByAdresseMail(String mail);


}
