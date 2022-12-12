import { getValor } from "./utils/get-valor.js";
import { validarCNPJ } from "./utils/validar-cpf-cnpj.js";
import { validarCPF } from "./utils/validar-cpf-cnpj.js";

function download() {
    var json = {"cnpj_ug": getValor('cnpj_ug'),"id_contratacao": getValor('id_contratacao'),"numero_processo": getValor('numero_processo'),"ano_processo": parseInt(getValor('ano_processo')),"numero_procedimento": parseInt(getValor('numero_processo')),"ano_procedimento": parseInt(getValor('ano_processo')),"data_publicacao": getValor('data_publicacao'),"numero_lei": parseInt(getValor('numero_lei')),"ano_lei": parseInt(getValor('ano_lei')),"cod_procedimento": getValor('cod_procedimento'),"criterio": parseInt(getValor('criterio')),"finalidade": parseInt(getValor('finalidade')),"sistema_pregao": getValor('sistema_pregao'),"data_adesao": getValor('data_adesao'),"regime_execucao": parseInt(getValor('regime_execucao')),"objeto": getValor('objeto'),"valor_estimado": parseFloat(getValor('valor_estimado')),"data_sessao": getValor('data_sessao'),"cpf_autoridade": getValor('cpf_autoridade'),"contrato_html": getValor('contrato_html')};
    var blob = new Blob([JSON.stringify(json, null, 0)], { type: 'application/json; charset=utf-8"' });
    saveAs(blob, "procedimento.json");
}

$(document).ready(function () {
    $('#cnpj_ug').mask('00000000000000');
    $('#ano_processo').mask('0000');
    $('#numero_procedimento').mask('000000');
    $('#ano_procedimento').mask('0000');
    $('#ano_lei').mask('0000');
    $('#numero_lei').mask('000000');
    $('#valor_estimado').mask("###0.00", {reverse: true});
    $('#data_publicacao').mask('0000-00-00', {placeholder: "AAAA-MM-DD"});
    $('#data_adesao').mask('0000-00-00', {placeholder: "AAAA-MM-DD"});
    $('#data_sessao').mask('0000-00-00', {placeholder: "AAAA-MM-DD"});
    $('#cpf_autoridade').mask('00000000000');
});

$(function () {
    var validator = $('#form-json').validate({
        errorClass: "is-invalid text-danger",
        rules: {
            cnpj_ug: {
                required: true,
                minlength: 14,
                verificadorCNPJ: true
            },            
            id_contratacao: {
                required: true,
                maxlength: 11
            },        
            numero_processo: {
                required: true,
                maxlength: 20
            },            
            ano_processo: {
                required: true,
                minlength: 4
            },            
            numero_procedimento: {
                required: true,
                maxlength: 6
            },            
            ano_procedimento: {
                required: true,
                minlength: 4
            },             
            numero_lei: {
                required: true,
                maxlength: 6
            },            
            ano_lei: {
                required: true,
                minlength: 4
            },             
            data_adesao: {
                minlength: 10
            },  
            data_publicacao: {
                minlength: 10
            },              
            data_sessao: {
                minlength: 10
            },            
            cod_procedimento: {
                required: true,
            },            
            finalidade: {
                required: true,
            },             
            regime_execucao: {
                required: true,
            },               
            objeto: {
                required: true,
            },             
            cpf_autoridade: {
                required: true,
                maxlength: 11,
                verificadorCPF: true
            },            
        },
        submitHandler: function(form){
            download();
        }
    });
    $.validator.messages.required = 'Campo obrigatório';
    $.validator.addMethod("verificadorCNPJ", function (value, element) {
        return validarCNPJ(value);
    }, "Digite um CNPJ válido");    
    $.validator.addMethod("verificadorCPF", function (value, element) {
        return validarCPF(value);
    }, "Digite um CPF válido");
});