package com.bibliotheque.service.impl;

import com.bibliotheque.entity.MembreEntity;
import com.bibliotheque.repository.LoginRepository;
import com.bibliotheque.service.contract.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository repository;

    public LoginServiceImpl() {
    }

    @Override
    public MembreEntity getMembreByEmailandAdresse(String mail, String motDePasse) {
        try {
            return this.repository.findByAdresseMailAndMotDePasse(mail, motDePasse);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public MembreEntity getMembrebyEmail(String mail) {

        return this.repository.findByAdresseMail(mail);
    }
}
