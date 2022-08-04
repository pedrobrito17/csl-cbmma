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
        "id_contratacao": getValor('id_contratacao'),
        "id_contrato": getValor('id_contrato'),
        "cpf_cnpj": getValor('cpf_cnpj'),
        "tipo": parseInt(getValor('tipo')),
        "numero_lei": parseInt(getValor('numero_lei')),
        "ano_lei": parseInt(getValor('ano_lei')),
        "data_notificacao": getValor('data_notificacao'),
        "data_inicio": getValor('data_inicio'),
        "data_fim": getValor('data_fim'),
        "amplitude": getValor('amplitude'),
    };
    var blob = new Blob([JSON.stringify(json, null, 4)], { type: 'application/json; charset=utf-8"' });
    saveAs(blob, "sancao.json");
}

$(document).ready(function () {
    $('#data_notificacao').mask('0000-00-00', { placeholder: "AAAA-MM-DD" });
    $('#data_inicio').mask('0000-00-00', { placeholder: "AAAA-MM-DD" });
    $('#data_fim').mask('0000-00-00', { placeholder: "AAAA-MM-DD" });
    $('#numero_lei').mask('000000');
    $('#ano_lei').mask('0000');
});

$(function () {
    var validator = $('#form-json').validate({
        errorClass: "is-invalid text-danger",
        rules: {
            id_contratacao: {
                required: true,
                maxlength: 11
            },
            id_contrato: {
                maxlength: 11
            },
            cpf_cnpj:{
                required: true,
                maxlength: 14
            },
            tipo:{
                required: true
            },      
            numero_lei:{
                required: true,
                maxlength: 6
            },      
            ano_lei:{
                required: true,
                maxlength: 4
            },
            data_notificacao: {
                required: true,
                minlength: 10
            },
            data_inicio: {
                minlength: 10
            },
            data_fim: {
                minlength: 10
            },
            amplitude:{
                required: true
            }
        },
        submitHandler: function (form) {
            download();
        }
    });
    $.validator.messages.required = 'Campo obrigatório';
});