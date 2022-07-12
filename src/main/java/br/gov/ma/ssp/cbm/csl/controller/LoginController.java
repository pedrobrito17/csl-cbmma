package br.gov.ma.ssp.cbm.csl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class LoginController{

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginPage(){
        return "login";
    }    

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView pageIndex() {
        ModelAndView mv = new ModelAndView("/index");
        return mv;
    }
}