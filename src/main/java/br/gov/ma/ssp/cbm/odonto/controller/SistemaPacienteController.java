package br.gov.ma.ssp.cbm.odonto.controller;

import javax.annotation.Resource;

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
public class SistemaPacienteController{

    @Autowired
    private BombeiroMilitarService bombeiroService;

    @Resource(name = "getBombeiroLogado")
    private BombeiroMilitar bombeiro;

    @RequestMapping(value="/meus-dados", method=RequestMethod.GET)
    public ModelAndView pageMeusDados() {
        ModelAndView mv = new ModelAndView("/meus-dados");
        mv.addObject("bombeiro", bombeiro);
        return mv;
    }

    @PostMapping(value="/atualizar-dados")
    public ModelAndView postMethodName(@ModelAttribute("bombeiro") BombeiroMilitar bombeiro) {
        bombeiroService.atualizarDados(bombeiro);
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
    
    
    @RequestMapping(value="/alterar-senha", method=RequestMethod.GET)
    public ModelAndView pageAlterarSenha() {
        ModelAndView mv = new ModelAndView("/alterar-senha");
        mv.addObject("bombeiro", bombeiro);
        return mv;
    }

    @RequestMapping(value="/minhas-consultas", method=RequestMethod.GET)
    public String pageMinhasConsultas() {
        return "minhas-consultas";
    }
    
}