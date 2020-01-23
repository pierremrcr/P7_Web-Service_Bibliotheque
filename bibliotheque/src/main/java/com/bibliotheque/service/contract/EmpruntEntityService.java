package com.bibliotheque.service.contract;

import com.bibliotheque.entity.EmpruntEntity;

import java.util.List;

public interface EmpruntEntityService {

    public EmpruntEntity getEmpruntById(int id);
    public List<EmpruntEntity> getAllEmprunts();
    public EmpruntEntity addEmprunt(EmpruntEntity emprunt);
    public boolean updateEmprunt(EmpruntEntity emprunt);
    public boolean deleteEmpruntById(int id);
    public List<EmpruntEntity> getAllEmpruntsWhereDateFinIsBeforeDateToday();
    boolean updateEmpruntTermine(EmpruntEntity emprunt);
}
