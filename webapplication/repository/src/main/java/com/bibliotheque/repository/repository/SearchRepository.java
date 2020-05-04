package com.bibliotheque.repository.repository;

import com.bibliotheque.repository.client.SearchClient;
import livres.wsdl.GetSearchByKeywordResponse;
import livres.wsdl.LivreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchRepository {

    @Autowired
    private SearchClient client;

    public List<LivreType> livreTypeListByKeyword(String keyword){
        GetSearchByKeywordResponse response = this.client.getSearchByKeyword(keyword);
        return response.getLivreType();
    }



}
