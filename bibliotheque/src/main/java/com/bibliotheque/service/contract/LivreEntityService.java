package com.bibliotheque.service.contract;

import com.bibliotheque.entity.LivreEntity;

import java.util.List;

public interface LivreEntityService {

    public LivreEntity getLivreById(int id);
    public LivreEntity getLivreByTitle(String title);
    public List<LivreEntity> getAllLivres();
    public LivreEntity addLivre(LivreEntity livreEntity);
    public boolean updateLivre(LivreEntity livreEntity);
    public boolean deleteLivreById(int id);
    public List<LivreEntity> getAllLivresByKeyword(String Keyword);
    public List<LivreEntity> getAllLivreEmpruntesByUser(int id);

}
