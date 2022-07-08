//DATEPICKER CONSULTA
$(function () {
  $("#datepicker").datepicker({
    dateFormat: 'dd/mm/yy',
    dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
    dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D'],
    dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb', 'Dom'],
    monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
    monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
    nextText: 'Próximo',
    prevText: 'Anterior',
    autoSize: true,
    showAnim: 'slide',
    minDate: 0,
    onSelect: function(date, inst){
      $('#dataSelecionada').empty();
      $('#dataSelecionada').append(date);
    },
    beforeShowDay: DisableSpecificDates
  });
});

function DisableSpecificDates(date) {

  var m = (date.getMonth()+1)<10 ? '0'+(date.getMonth()+1) : (date.getMonth()+1);
  var d = (date.getDate()<10) ? '0'+date.getDate() : date.getDate();
  var y = date.getFullYear();

  var currentdate = y + '-' + m + '-' + d;

  var dateDisabled = disableSundayAndSaturday(date);
  return dateDisabled;
}

function disableSundayAndSaturday(date) {
  var day = date.getDay();
  return [(day != 0 && day != 6), ""];
}



