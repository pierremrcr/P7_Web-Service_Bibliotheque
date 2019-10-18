package com.bibliotheque.controller;

import com.bibliotheque.service.MembreService;
import livres.wsdl.MembreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class MembreController {

    private MembreService service;

    @Autowired
    public MembreController(MembreService service) {

        this.service = service;
    }

    @RequestMapping(value = "/membre", method = RequestMethod.GET)
    public String compte(){

        return "membre";
    }

    @RequestMapping(value="/detail-membre", method= RequestMethod.GET)
    public String membreDetail(Model model, @RequestParam(name="id") Integer id){

        MembreType membreType = this.service.membreById(id);

        model.addAttribute("membre", membreType);

        return "detailMembre";

    }

    @RequestMapping(value="/addmembre", method = RequestMethod.GET)
    public String addMembre(Model model){

        MembreType membreType = new MembreType();
        model.addAttribute("membreType", membreType);

       return "formulaireMembre";
    }


    @RequestMapping(value = "/addmembre", method = RequestMethod.POST)
    public String saveMembre(@Valid @ModelAttribute("membreType") MembreType membreType, BindingResult result, ModelMap model){

        if(result.hasErrors()){
            return "error";
        }else{
            this.service.addMembre(membreType);
            return "confirmationInscription";
        }


    }


}


