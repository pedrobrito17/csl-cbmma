package br.gov.ma.ssp.cbm.csl.controller;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.ma.ssp.cbm.csl.model.BombeiroMilitar;
import br.gov.ma.ssp.cbm.csl.service.BombeiroMilitarService;

@Controller
public class SistemaController{

    @Autowired
    private BombeiroMilitarService bombeiroService;

    org.slf4j.Logger logger = LoggerFactory.getLogger(SistemaController.class);

    @Resource(name = "getBombeiroLogado")
    private BombeiroMilitar bombeiro;

    @RequestMapping(value="/csl-unidade/meus-dados", method=RequestMethod.GET)
    public ModelAndView pageMeusDados() {
        ModelAndView mv = new ModelAndView("/meus-dados");
        mv.addObject("bombeiro", bombeiroService.getBombeiroLogado());
        return mv;
    }

    @PostMapping(value="/csl-unidade/atualizar-dados")
    public ModelAndView postAtualizarDados(@ModelAttribute("bombeiro") BombeiroMilitar bombeiro, RedirectAttributes redirectAttributes) {
        bombeiro = bombeiroService.atualizarDados(bombeiro);
        ModelAndView mv = new ModelAndView("redirect:/");
        redirectAttributes.addFlashAttribute("msgSuccess", "Dados alterados com sucesso.");
        return mv;
    }    
    
    @PostMapping(value="/csl-unidade/atualizar-senha")
    public ModelAndView postAtualizarSenha(@ModelAttribute("bombeiro") BombeiroMilitar bombeiro, RedirectAttributes redirectAttributes) {
        bombeiroService.atualizarSenha(bombeiro);
        ModelAndView mv = new ModelAndView("redirect:/");
        redirectAttributes.addFlashAttribute("msgSuccess", "Senha alterada com sucesso.");
        return mv;
    }
    
    @RequestMapping(value="/csl-unidade/alterar-senha", method=RequestMethod.GET)
    public ModelAndView pageAlterarSenha() {
        ModelAndView mv = new ModelAndView("/alterar-senha");
        mv.addObject("bombeiro", bombeiro);
        return mv;
    }

    @RequestMapping(value="/csl-unidade/procedimento", method=RequestMethod.GET)
    public ModelAndView pagerProcedimento() {
        ModelAndView mv = new ModelAndView("/conversor/procedimento");
        return mv;
    }  

    @RequestMapping(value="/csl-unidade/gerar-json", method=RequestMethod.POST, consumes = {"application/json"})
    public String gerarJson(@RequestBody Object json, Model model) {
        logger.info("############TESTANDO################");
        // logger.info(json.toString());

        model.addAttribute("message", "Arquivo enviado");
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