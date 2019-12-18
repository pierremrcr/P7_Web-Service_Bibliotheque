package com.bibliotheque.controller;

import com.bibliotheque.service.EmpruntService;
import com.bibliotheque.service.ExemplaireService;
import livres.wsdl.EmpruntType;
import livres.wsdl.ExemplaireType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @Autowired
    private ExemplaireService exemplaireService;



    @RequestMapping(value = "/prolongation", method = RequestMethod.GET)
    public String updateEmprunt(@RequestParam(name = "empruntId")Integer empruntId,
                                 HttpSession session) {

        EmpruntType empruntType = empruntService.getEmpruntById(empruntId);

        empruntService.updateEmprunt(empruntType);

        return "ConfirmationProlongation";

    }

    /*
    @RequestMapping(value="/addEmprunt", method = RequestMethod.GET)
    public String doBorrow(Model model){

        ExemplaireType exemplaireType = new ExemplaireType();

        model.addAttribute("exemplaire", exemplaireType);

        return "reservationForm";

    }

    */

    @RequestMapping(value="/addEmprunt", method = RequestMethod.POST)
    public String doBorrow(@RequestParam(name = "exemplaireId") Integer exemplaireId,
                           Model model,
                           HttpSession session){

        EmpruntType empruntType = new EmpruntType();

        ExemplaireType exemplaireType = exemplaireService.exemplaireById(exemplaireId);

        empruntService.addEmprunt(empruntType);

        return "confirmationReservation";

    }
}
