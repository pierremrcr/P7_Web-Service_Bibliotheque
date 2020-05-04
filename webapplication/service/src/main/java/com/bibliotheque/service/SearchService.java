package com.bibliotheque.service;

import com.bibliotheque.repository.repository.SearchRepository;
import livres.wsdl.LivreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = "com.bibliotheque.repository")
public class SearchService {


    @Autowired
    private SearchRepository searchRepository;

    public List<LivreType> livreTypeListByKeyword(String keyword) {
        return searchRepository.livreTypeListByKeyword(keyword);
    }

}

