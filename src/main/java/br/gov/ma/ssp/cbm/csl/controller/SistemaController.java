package br.gov.ma.ssp.cbm.csl.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SistemaController {

    org.slf4j.Logger logger = LoggerFactory.getLogger(SistemaController.class);

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String pageIndex() {
        return "index";
    }

    @RequestMapping(value = "/csl-unidade/procedimento", method = RequestMethod.GET)
    public String pagerProcedimento() {
        return "conversor/procedimento";
    }

    @RequestMapping(value = "/csl-unidade/resultado", method = RequestMethod.GET)
    public String pagerResultado() {
        return "conversor/resultado";
    }

    @RequestMapping(value = "/csl-unidade/ata-registro", method = RequestMethod.GET)
    public String pageAtaRegistro() {
        return "conversor/ata-registro";
    }

    @RequestMapping(value = "/csl-unidade/cadastro-orgao", method = RequestMethod.GET)
    public String pageCadastroOrgao() {
        return "conversor/cadastro-orgao";
    }

    @RequestMapping(value = "/csl-unidade/cadastro-licitante", method = RequestMethod.GET)
    public String pageCadastroCliente() {
        return "conversor/cadastro-licitante";
    }

    @RequestMapping(value = "/csl-unidade/contrato", method = RequestMethod.GET)
    public String pageContrato() {
        return "conversor/contrato";
    }

    @RequestMapping(value = "/csl-unidade/sancao", method = RequestMethod.GET)
    public String pageSancao() {
        return "conversor/sancao";
    }

}