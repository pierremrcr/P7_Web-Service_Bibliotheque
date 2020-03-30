package com.bibliotheque.web.controller;

import com.bibliotheque.service.LivreService;
import com.bibliotheque.service.SearchService;
import livres.wsdl.LivreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private LivreService livreService;


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchOuvrageByKeyword(Model model, @RequestParam(value = "keyword") String keyword) {

        List<LivreType> livreTypeList = searchService.livreTypeListByKeyword(keyword);

        livreTypeList = livreService.exemplairesDispoParLivre(livreTypeList);

        model.addAttribute("listeLivres", livreTypeList);

        return "searchResult";
    }
}