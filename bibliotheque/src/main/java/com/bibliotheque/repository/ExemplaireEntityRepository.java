package com.bibliotheque.repository;

import com.bibliotheque.entity.ExemplaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExemplaireEntityRepository extends JpaRepository<ExemplaireEntity, Integer> {

    List<ExemplaireEntity> findAll();

    ExemplaireEntity findById(int id);

    ExemplaireEntity save(ExemplaireEntity exemplaireEntity);

    //Query qui me retourne une liste d'exemplaires et ses emprunts
   // @Query("SELECT exemplaire FROM ExemplaireEntity exemplaire INNER JOIN exemplaire.listeEmprunts WHERE membre.id =:id")
  //  List<ExemplaireEntity> findAllExemplairesAndEmprunts(@Param("id") int id);


    @Query("SELECT exemplaire, emprunt, membre FROM ExemplaireEntity exemplaire, EmpruntEntity emprunt, MembreEntity membre WHERE exemplaire.id = emprunt.exemplaireid AND membre.id =:id")
    List<ExemplaireEntity> findAllExemplairesAndEmprunts(@Param("id") int id);
}