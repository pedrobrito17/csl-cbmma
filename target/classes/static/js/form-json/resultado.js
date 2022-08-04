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
        "licitacao": getValor('licitacao'),
        "data": getValor('data'),
        "valor": parseFloat(getValor('valor')),
    };
    var blob = new Blob([JSON.stringify(json, null, 4)], { type: 'application/json; charset=utf-8"' });
    saveAs(blob, "resultado.json");
}

$(document).ready(function () {
    $('#data').mask('0000-00-00', { placeholder: "AAAA-MM-DD" });
    $('#valor').mask("###0.00", {reverse: true});
});

$(function () {
    var validator = $('#form-json').validate({
        errorClass: "is-invalid text-danger",
        rules: {
            id_contratacao: {
                required: true,
                maxlength: 11
            },
            licitacao: {
                required: true,
            },
            data: {
                required: true,
                minlength: 10
            },
        },
        submitHandler: function (form) {
            download();
        }
    });
    $.validator.messages.required = 'Campo obrigatório';
});