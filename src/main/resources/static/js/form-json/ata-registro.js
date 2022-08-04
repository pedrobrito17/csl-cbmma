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
        "valor": parseFloat(getValor('valor')),
        "data_inicio": getValor('data_inicio'),
        "data_fim": getValor('data_fim'),
        "ata_html": getValor('ata_html'),
    };

    var blob = new Blob([JSON.stringify(json, null, 4)], { type: 'application/json; charset=utf-8"' });
    saveAs(blob, "ata_registro.json");
}

$(document).ready(function () {
    $('#ano').mask('0000');
    $('#data_inicio').mask('0000-00-00', { placeholder: "AAAA-MM-DD" });
    $('#data_fim').mask('0000-00-00', { placeholder: "AAAA-MM-DD" });
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
            numero: {
                required: true,
                maxlength: 10
            },
            ano: {
                required: true,
                minlength: 4
            },
            valor: {
                required: true,
            },
            data_inicio: {
                required: true,
                minlength: 10
            },            
            data_fim: {
                required: true,
                minlength: 10
            },            
            ata_html: {
                required: true,
            },
        },
        submitHandler: function (form) {
            download();
        }
    });
    $.validator.messages.required = 'Campo obrigatório';
});