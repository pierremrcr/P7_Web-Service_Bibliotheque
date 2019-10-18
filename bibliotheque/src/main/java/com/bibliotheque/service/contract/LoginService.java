package com.bibliotheque.service.contract;

import com.bibliotheque.entity.MembreEntity;

public interface LoginService {

    MembreEntity getMembreByEmailandAdresse(String mail, String motDePasse);

    MembreEntity getMembrebyEmail(String mail);
}
