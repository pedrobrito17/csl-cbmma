package br.gov.ma.ssp.cbm.odonto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.gov.ma.ssp.cbm.odonto.service.BombeiroMilitarService;


@Controller
public class CleanController{

    @Autowired
    private BombeiroMilitarService service;

    @RequestMapping(value="/cleanbd", method=RequestMethod.GET)
    public void limparBancoDados() {
        service.limparBancoDados();
        // return "clean";
    }
    

}