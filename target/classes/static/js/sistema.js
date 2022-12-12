$(function(){
    var titulo = $('#titulo-page').html();
    var titulosArray = {
        "": "home",
        "MEUS DADOS": "meus-dados",
        "ALTERAR SENHA": "alterar-senha",
        "USUÁRIOS CADASTRADOS": "usuarios-cadastrados",
        "PROCEDIMENTO": "procedimento",
        "RESULTADO": "resultado",
        "ATA REGISTRO": "ata_registro",
        "CADASTRO ÓRGÃO": "cadastro_orgao",
        "CADASTRO CLIENTE": "cadastro_cliente",
        "CONTRATO": "contrato",
        "SANÇÃO": "sancao"
    };

    $('#'+titulosArray[titulo]).addClass('menu-selecionado');
});

$(function(){
    $('#sair').click(function(){
        $('#form-sair').submit();
    });
});