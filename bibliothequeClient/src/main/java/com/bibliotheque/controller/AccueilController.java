package com.bibliotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccueilController {

    @RequestMapping(value = "/")
    public String accueil(){

        return "accueil";

    }

    @RequestMapping(value = "/403")
    public String notAuthorized(){
        return "error/403";
    }
}
