package com.bibliotheque.controller;

import com.bibliotheque.service.LivreService;
import livres.wsdl.EmpruntType;
import livres.wsdl.ExemplaireType;
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

        livreTypeList = livreService.exemplairesDispoParLivre(livreTypeList);

        model.addAttribute("listeLivres", livreTypeList);

        return "listeLivres";

    }



    @RequestMapping(value="/livre", method = RequestMethod.GET)
    public String livreDetail(Model model, @RequestParam(name="id") Integer id){

        LivreType livreType = livreService.livreById(id);

        List<ExemplaireType> exemplairesListe = livreService.nombreExemplaireDispo(livreType.getListeExemplaires());

        for (ExemplaireType exemplaireType : exemplairesListe){
            model.addAttribute("exemplaire", exemplaireType);
        }

        EmpruntType empruntType = new EmpruntType();

        model.addAttribute("emprunt", empruntType);

        model.addAttribute("exemplairesDispo",exemplairesListe);

        model.addAttribute("livre", livreType);

        return "livre";


    }




}
