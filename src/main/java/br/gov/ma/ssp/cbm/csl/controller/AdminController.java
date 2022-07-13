package br.gov.ma.ssp.cbm.csl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.ma.ssp.cbm.csl.service.BombeiroMilitarService;

@Controller
public class AdminController {

    @Autowired
    private BombeiroMilitarService bombeiroService;

    @RequestMapping(value="/csl-central/usuarios-cadastrados", method=RequestMethod.GET)
    public ModelAndView pageMinhasConsultas() {
        ModelAndView mv = new ModelAndView("/admin/usuarios-cadastrados");
        mv.addObject("bombeiros", bombeiroService.getTodosBombeiros());
        return mv;
    }

    @RequestMapping(value="/csl-central/resetar-senha/{id}", method=RequestMethod.GET)
    public ModelAndView resetarSenha(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        if(bombeiroService.resetarSenha(id) != null){
            redirectAttributes.addFlashAttribute("msgSuccess", "A senha do usuário foi resetada.");
        }
        else{
            redirectAttributes.addFlashAttribute("msgError", "Não foi possível resetar a senha do usuário.");
        }
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }

    @RequestMapping(value="/csl-central/ativo/{id}", method=RequestMethod.GET)
    public ModelAndView tornarAtivo(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        if(bombeiroService.tornarAtivo(id) != null){
            redirectAttributes.addFlashAttribute("msgSuccess", "Usuário ativado.");
        }
        else{
            redirectAttributes.addFlashAttribute("msgError", "Usuário não foi ativado. Tente novamente.");
        }
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
    
}
