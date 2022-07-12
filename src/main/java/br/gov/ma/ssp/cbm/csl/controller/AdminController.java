package br.gov.ma.ssp.cbm.csl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @RequestMapping(value="/csl-central/usuarios-cadastrados", method=RequestMethod.GET)
    public String pageMinhasConsultas() {
        return "admin/usuarios-cadastrados";
    }
    
}
