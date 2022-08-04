function getValor(text) {
    var dado = $("#" + text).val();
    if (!dado) {
        return null;
    }
    else {
        return dado;
    }
}

function download() {
    var json = {
        "cnpj_ug": getValor('cnpj_ug'),
        "numero_processo": getValor('numero_processo'),
        "ano_processo": parseInt(getValor('ano_processo')),
        "numero_contrato": parseInt(getValor('numero_contrato')),
        "ano_contrato": parseInt(getValor('ano_contrato')),
        "id_contratacao": getValor('id_contratacao'),
        "id_contrato": getValor('id_contrato'),
        "cpf_cnpj": getValor('cpf_cnpj'),
        "objeto": getValor('objeto'),
        "tipo": parseInt(getValor('tipo')),
        "data_assinatura": getValor('data_assinatura'),
        "data_inicio": getValor('data_inicio'),
        "data_fim": getValor('data_fim'),
        "valor": parseFloat(getValor('valor')),
        "contrato_html": getValor('contrato_html'),
    };
    var blob = new Blob([JSON.stringify(json, null, 4)], { type: 'application/json; charset=utf-8"'});
    saveAs(blob, "contrato.json");
}

$(document).ready(function () {
    $('#cnpj_ug').mask('00000000000000');
    $('#cpf_cnpj').mask('00000000000000');
    $('#ano_processo').mask('0000');
    $('#ano_contrato').mask('0000');
    $('#numero_contrato').mask('000000');
    $('#data_assinatura').mask('0000-00-00', {placeholder: "AAAA-MM-DD"});
    $('#data_inicio').mask('0000-00-00', {placeholder: "AAAA-MM-DD"});
    $('#data_fim').mask('0000-00-00', {placeholder: "AAAA-MM-DD"});
    $('#valor').mask("###0.00", {reverse: true});
});

$(function () {
    var validator = $('#form-json').validate({
        errorClass: "is-invalid text-danger",
        rules: {
            cnpj_ug: {
                required: true,
                minlength: 14
            }, 
            numero_processo: {
                required: true,
                maxlength: 20
            },             
            ano_processo: {
                required: true,
                maxlength: 4
            },              
            numero_contrato: {
                required: true,
                maxlength: 6
            },   
            ano_contrato: {
                required: true,
                maxlength: 4
            },             
            id_contratacao: {
                required: true,
                maxlength: 11
            },              
            id_contrato: {
                required: true,
                maxlength: 11
            },   
            cpf_cnpj: {
                required: true,
                maxlength: 14
            },   
            objeto:{
                required: true,
                maxlength: 400
            },
            tipo:{
                required: true
            },
            data_assinatura:{
                required: true,
                maxlength:10
            },            
            data_inicio:{
                required: true,
                maxlength:10
            },        
            data_fim:{
                required: true,
                maxlength:10
            },        
            valor:{
                required: true,
            },
            contrato_html:{
                required: true
            }
        },
        submitHandler: function(form){
            download();
        }
    });
    $.validator.messages.required = 'Campo obrigatório';
});