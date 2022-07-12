package br.gov.ma.ssp.cbm.csl.controller;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import br.gov.ma.ssp.cbm.csl.model.BombeiroMilitar;
import br.gov.ma.ssp.cbm.csl.service.BombeiroMilitarService;

@Controller
public class SistemaController{

    @Autowired
    private BombeiroMilitarService bombeiroService;

    @Resource(name = "getBombeiroLogado")
    private BombeiroMilitar bombeiro;

    @RequestMapping(value="/csl-unidade/meus-dados", method=RequestMethod.GET)
    public ModelAndView pageMeusDados() {
        ModelAndView mv = new ModelAndView("/meus-dados");
        mv.addObject("bombeiro", bombeiro);
        return mv;
    }

    @PostMapping(value="/csl-unidade/atualizar-dados")
    public ModelAndView postAtualizarDados(@ModelAttribute("bombeiro") BombeiroMilitar bombeiro) {
        bombeiro = bombeiroService.atualizarDados(bombeiro);
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }    
    
    @PostMapping(value="/csl-unidade/atualizar-senha")
    public ModelAndView postAtualizarSenha(@ModelAttribute("bombeiro") BombeiroMilitar bombeiro) {
        bombeiro = bombeiroService.atualizarSenha(bombeiro);
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
    
    @RequestMapping(value="/csl-unidade/alterar-senha", method=RequestMethod.GET)
    public ModelAndView pageAlterarSenha() {
        ModelAndView mv = new ModelAndView("/alterar-senha");
        mv.addObject("bombeiro", bombeiro);
        return mv;
    }

    @RequestMapping(value="/csl-unidade/procedimento", method=RequestMethod.GET)
    public String pagerProcedimento() {
        return "conversor/procedimento";
    }  
    
    @RequestMapping(value="/csl-unidade/resultado", method=RequestMethod.GET)
    public String pagerResultado() {
        return "conversor/resultado";
    }    
    
    @RequestMapping(value="/csl-unidade/ata-registro", method=RequestMethod.GET)
    public String pageAtaRegistro() {
        return "conversor/ata-registro";
    }

    @RequestMapping(value="/csl-unidade/cadastro-orgao", method=RequestMethod.GET)
    public String pageCadastroOrgao() {
        return "conversor/cadastro-orgao";
    }    
    
    @RequestMapping(value="/csl-unidade/cadastro-cliente", method=RequestMethod.GET)
    public String pageCadastroCliente() {
        return "conversor/cadastro-cliente";
    }    
    
    @RequestMapping(value="/csl-unidade/contrato", method=RequestMethod.GET)
    public String pageContrato() {
        return "conversor/contrato";
    }    
    
    @RequestMapping(value="/csl-unidade/sancao", method=RequestMethod.GET)
    public String pageSancao() {
        return "conversor/sancao";
    }
    
}