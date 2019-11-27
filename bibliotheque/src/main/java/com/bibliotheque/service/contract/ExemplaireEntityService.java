package com.bibliotheque.service.contract;

import com.bibliotheque.entity.ExemplaireEntity;

import java.util.List;

public interface ExemplaireEntityService {

    public ExemplaireEntity getExemplaireById(int id);
    public List<ExemplaireEntity> getAllExemlaires();
    public ExemplaireEntity addExemplaire(ExemplaireEntity exemplaireEntity);
    public boolean deleteExemplaireById(int id);
    public boolean updateExemplaire(ExemplaireEntity exemplaireEntity);
    List<ExemplaireEntity> getAllExemplairesAndEmprunts(int id);

}

