function gerarJson() {

    var json = { "cnpj_ug": "74134461000193", "id_contratacao": "321321", "numero_processo": "2", "ano_processo": null, "numero_procedimento": 2, "ano_procedimento": 2022, "data_publicacao": null, "numero_lei": null, "ano_lei": null, "cod_procedimento": "DP", "criterio": null, "finalidade": null, "sistema_pregao": null, "data_adesao": null, "regime_execucao": null, "objeto": null, "valor_estimado": null, "data_sessao": null, "cpf_autoridade": null, "edital_html": null };
    var endereco = '';
    // var json = {"nome": "Pedro"}

    $.ajax({
        url: endereco + '/csl-unidade/gerar-json',
        type: 'POST',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: "json",
    })
        .success(function (data) {
            window.location='@Url.Action("Download","BaixarConta")?file='+retorno.FileGuid;
        })
        .done(function () {
            console.log("baixado");
        })
        .fail(function (jqXHR, textStatus, errorThrown) {
            alert("Desculpe! Houve um erro: " + jqXHR.status);
        });

}