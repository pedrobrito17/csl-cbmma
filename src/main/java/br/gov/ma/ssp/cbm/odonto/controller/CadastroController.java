package br.gov.ma.ssp.cbm.odonto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import br.gov.ma.ssp.cbm.odonto.model.BombeiroMilitar;
import br.gov.ma.ssp.cbm.odonto.service.BombeiroMilitarService;

@Controller
public class CadastroController{

    @Autowired
    private BombeiroMilitarService service;

    @RequestMapping(value="/cadastro", method=RequestMethod.GET)
    public ModelAndView cadastroPage() {
        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("bombeiro", new BombeiroMilitar());
        return mv;
    }

    @PostMapping(value="/cadastrar-novo-bombeiro")
    public String cadastrarBombeiro(@ModelAttribute("bombeiro") BombeiroMilitar bombeiro){
        service.salvarNovoUsuario(bombeiro);
        return "retorno";
    }
}