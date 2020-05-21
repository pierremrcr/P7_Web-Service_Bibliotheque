package com.bibliotheque.service;

import com.bibliotheque.repository.repository.LivreRepository;
import livres.wsdl.ExemplaireType;
import livres.wsdl.LivreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreRepository repository;

    public LivreType livreById(int id){

        return this.repository.livreById(id);
    }

    public List<LivreType> livreTypeList(){

        return this.repository.livreTypeList();
    }

    public List<LivreType> getAllLivresEmpruntes(int id){

        return this.repository.getAllLivresEmpruntes(id);
    }

    public List<ExemplaireType> nombreExemplaireDispo(List<ExemplaireType> exemplaireTypeList){

        List<ExemplaireType> listeExemplairesDispo = new ArrayList<>();

        for(ExemplaireType exemplaireType: exemplaireTypeList){
            if(exemplaireType.isDisponibilite()){
                listeExemplairesDispo.add(exemplaireType);
            }

        }
        return listeExemplairesDispo;
    }

    public List<LivreType> exemplairesDispoParLivre(List<LivreType> listeLivres){

        for(LivreType livreType : listeLivres){

            List<ExemplaireType> listeExemplaires = nombreExemplaireDispo(livreType.getListeExemplaires());
            livreType.getListeExemplaires().clear();
            livreType.getListeExemplaires().addAll(listeExemplaires);
        }

        return listeLivres;
    }

}
