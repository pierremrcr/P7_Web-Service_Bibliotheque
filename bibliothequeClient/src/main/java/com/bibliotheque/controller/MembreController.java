package com.bibliotheque.controller;

import com.bibliotheque.service.EmpruntService;
import com.bibliotheque.service.ExemplaireService;
import com.bibliotheque.service.LivreService;
import com.bibliotheque.service.MembreService;
import livres.wsdl.LivreType;
import livres.wsdl.MembreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;


@Controller
public class MembreController {

    private MembreService service;

    private EmpruntService empruntService;

    @Autowired
    private LivreService livreService;

    private ExemplaireService exemplaireService;


    @Autowired
    public MembreController(MembreService service, EmpruntService empruntService) {
        this.service = service;
        this.empruntService = empruntService;
    }

    @RequestMapping(value="/detail-membre", method= RequestMethod.GET)
    public String membreDetail(Model model, HttpSession session, MembreType membreType, @RequestParam(name="compteId") int id){


        membreType = this.service.membreById(id);

        List<LivreType> listeLivres = this.livreService.getAllLivresEmpruntes(id);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        model.addAttribute("membreType", membreType);

        model.addAttribute("dateFormat", dateFormat);

        model.addAttribute("listeLivres", listeLivres);

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


    @RequestMapping(value="/updatemembre", method = RequestMethod.POST)
    public String confirmUpdate(@Valid MembreType membreType, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "error";
        } else{
            this.service.updateMembre(membreType);
            return "detailMembre";
        }
    }

}


