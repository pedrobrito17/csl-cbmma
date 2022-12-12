$(document).ready(function () {
    $("[name='username']").mask('#-0', {
        reverse: true
    });
});

$(function () {
    $('#form-login').validate({
        errorClass: "is-invalid",
        rules: {
            username: "required",
            password: "required",
        },
        messages: {
            username: "Digite o número da sua matrícula",
            password: "Digite sua senha",
        }
    });
});