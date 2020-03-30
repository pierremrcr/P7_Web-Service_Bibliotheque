package com.bibliotheque.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String accueil(){

        return "home";

    }

    @RequestMapping(value = "/403")
    public String notAuthorized(){
        return "error/403";
    }
}