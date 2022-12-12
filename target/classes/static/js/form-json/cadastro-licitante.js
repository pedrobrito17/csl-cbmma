import { validarCPFeCNPJ } from "./utils/validar-cpf-cnpj.js";
import { getValor } from "./utils/get-valor.js";

function download() {
    var json = {"id_contratacao": getValor('id_contratacao'),"estrangeiro": getValor('estrangeiro'),"cpf_cnpj": getValor('cpf_cnpj'),"numero": getValor('numero'),"ano": parseInt(getValor('ano'))};
    var blob = new Blob([JSON.stringify(json, null, 0)], { type: 'application/json; charset=utf-8"' });
    saveAs(blob, "cadastro_licitante.json");
}

$(document).ready(function () {
    $('#ano').mask('0000');
    $('#cpf_cnpj').mask('00000000000000');
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
                minlength: 11,
                maxlength: 14,
                verificador: true
            }, 
        },
        submitHandler: function (form) {
            download();
        }
    });
    $.validator.messages.required = 'Campo obrigatório';
    $.validator.addMethod("verificador", function (value, element) {
        return validarCPFeCNPJ(value);
    }, "Digite um CPF/CNPJ válido");
});




