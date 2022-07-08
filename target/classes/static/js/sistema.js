$(function(){
    var titulo = $('#titulo-page').html();
    var titulosArray = {
        "MARCAÇÃO DE CONSULTA": "marcacao-consulta",
        "MEUS DADOS": "meus-dados",
        "ALTERAR SENHA": "alterar-senha",
        "MINHAS CONSULTAS": "minhas-consultas"
    };

    $('#'+titulosArray[titulo]).addClass('menu-selecionado');
});

$(function(){
    $('#sair').click(function(){
        $('#form-sair').submit();
    });
});