package com.bibliotheque.controller;

import com.bibliotheque.service.EmpruntService;
import livres.wsdl.EmpruntType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @RequestMapping(value = "/prolongation", method = RequestMethod.GET)
    public String updateEmprunt(@RequestParam(name = "empruntId")Integer empruntId,
                                 HttpSession session) {

        EmpruntType empruntType = empruntService.getEmpruntById(empruntId);

        empruntService.updateEmprunt(empruntType);

        return "ConfirmationProlongation";

    }
}
