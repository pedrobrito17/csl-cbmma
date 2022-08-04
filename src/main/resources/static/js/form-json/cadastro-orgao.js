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
        "numero": getValor('numero'),
        "ano": parseInt(getValor('ano')),
        "cnpj_ug": getValor('cnpj_ug'),
        "perfil": getValor('perfil'),
    };

    var blob = new Blob([JSON.stringify(json, null, 4)], { type: 'application/json; charset=utf-8"' });
    saveAs(blob, "cadastro_orgao.json");
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
            numero: {
                required: true,
                maxlength: 10
            },
            ano: {
                required: true,
                minlength: 4
            },
            cnpj_ug: {
                required: true,
                minlength: 14
            }, 
            perfil: {
                required: true
            }
        },
        submitHandler: function (form) {
            download();
        }
    });
    $.validator.messages.required = 'Campo obrigatório';
});