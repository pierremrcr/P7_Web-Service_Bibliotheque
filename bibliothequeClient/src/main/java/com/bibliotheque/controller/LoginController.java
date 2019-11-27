package com.bibliotheque.controller;

import com.bibliotheque.service.LoginService;
import livres.wsdl.MembreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;



@Controller
public class LoginController {


    private LoginService service;

    @Autowired
    public LoginController(LoginService service) {
        this.service = service;
    }


    @RequestMapping(value="/loginApp", method = RequestMethod.GET)
    public String init(Model model){
        MembreType membreType = new MembreType();
        model.addAttribute("login", membreType);
        return "login";
    }

    @RequestMapping(value="/loginApp", method = RequestMethod.POST)
    public String submit(Model model,
                         @Valid @ModelAttribute("login") MembreType membreType,
                         @RequestParam(name="mail") String mail,
                         @RequestParam(name="motDePasse") String motDePasse,
                         HttpSession session) {


        String result;


        try {

            membreType = this.service.loginCompte(mail, motDePasse);

            if (membreType != null) {
                session.setAttribute("user", membreType);
                result = "accueil";

            } else{
                model.addAttribute("login", "Mot de passe ou email invalide");
                result = "login";

            }

        } catch(Exception e){
            result = "login";
        }

        return result;
    }



    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "accueil";
    }






}
