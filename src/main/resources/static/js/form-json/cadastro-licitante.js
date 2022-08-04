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
        "estrangeiro": getValor('estrangeiro'),
        "cpf_cnpj": getValor('cpf_cnpj'),
        "numero": getValor('numero'),
        "ano": getValor('ano'),
    };

    var blob = new Blob([JSON.stringify(json, null, 4)], { type: 'application/json; charset=utf-8"' });
    saveAs(blob, "cadastro_licitante.json");
}

$(document).ready(function () {
    $('#ano').mask('0000');
    $('#cnpj_ug').mask('00000000000000');
});

$(function () {
    var validator = $('#form-json').validate({
        errorClass: "is-invalid text-danger",
        rules: {
            id_contratacao: {
                required: true,
                maxlength: 11
            },            
            estrangeiro: {
                required: true,
            },
            numero: {
                maxlength: 10
            },
            ano: {
                minlength: 4
            },
            cpf_cnpj: {
                required: true,
                maxlength: 14
            }, 
        },
        submitHandler: function (form) {
            download();
        }
    });
    $.validator.messages.required = 'Campo obrigatório';
});