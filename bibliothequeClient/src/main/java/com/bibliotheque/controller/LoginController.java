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

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String init(Model model){
        MembreType membreType = new MembreType();
        model.addAttribute("login", membreType);
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("login") MembreType membreType,
                         @RequestParam(name="mail") String mail,
                         @RequestParam(name="motDePasse") String motDePasse,
                         HttpSession session) {


        try {
            membreType = this.service.login(mail, motDePasse);
           session.setAttribute("user", membreType);
        } catch (Exception e) {
            e.getMessage();
            return "login";
        }

        return "compte";
    }


    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "accueil";
    }




}
