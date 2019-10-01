package com.bibliotheque.controller;

import com.bibliotheque.service.LivreService;
import livres.wsdl.LivreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LivreController {

    @Autowired
    private LivreService livreService;

    @RequestMapping(value="/livres", method= RequestMethod.GET)
    public String livres(final Model model){

        List<LivreType> livreTypeList = livreService.livreTypeList();

        model.addAttribute("listeLivres", livreTypeList);

        return "listeLivres";

    }

    @RequestMapping(value="/livre", method = RequestMethod.GET)
    public String livreDetail(Model model, @RequestParam(name="id") Integer id){

        LivreType livreType = livreService.livreById(id);

        model.addAttribute("livre", livreType);

        return "livre";


    }


}
