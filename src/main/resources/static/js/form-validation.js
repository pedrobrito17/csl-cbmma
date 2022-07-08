$(document).ready(function () {
    $('#numIdFuncional').mask('0000');
    $('#celular').mask('(00) 00000-0000');
    $('#matricula').mask('#-0', {
        reverse: true
    });
});

$(function(){
    $('#form-cadastro').validate({
        errorClass: "is-invalid text-danger",
        rules: {
            nomeCompleto: {
                required: true,
                minlength: 5
            },
            matricula: {
                required: true,
                minlength: 6
            },
            numIdFuncional: "required",
            nomeGuerra: "required",
            celular: "required",
            email : {
                required: true,
                email: true
            },
            confEmail : {
                required: true,
                email: true,
                equalTo : ".email"
            },
            confSenha : {
                equalTo : "#senha"
            }
        },
        messages: {
            nomeCompleto: "Digite seu nome completo",
            numIdFuncional: "Digite o número da sua identidade funcional",
            matricula: {
                "required": "Digite sua matrícula"
            },
            nomeGuerra : "Digite seu nome de guerra",
            celular : "Digite o número do seu celular",
            email :  {
                "required" : "Digite seu e-mail",
                "email": "Digite um e-mail válido"
            },
            confEmail : {
                "required": "Confirme seu e-mail",
                "email": "Digite um e-mail válido",
                "equalTo" : "E-mail não confere"
            },
            confSenha : {
                "equalTo" : "Senha não confere"
            }
        }
    });
});