$(function () {
    $.getJSON('https://servicodados.ibge.gov.br/api/v1/localidades/estados/21/municipios', function (json) {

        var options = '<option value="" disabled selected></option>';

        for (var i = 0; i < json.length; i++) {
            options += '<option value="' + json[i].nome + '" >' + json[i].nome + '</option>';
        }
        $("select[name='municipioUnidade']").html(options);
    });
});




