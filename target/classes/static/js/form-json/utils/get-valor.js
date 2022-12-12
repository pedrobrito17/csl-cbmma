export function getValor(text) {
    var dado = $("#" + text).val();
    if (!dado) {
        return null;
    }
    else {
        return dado;
    }
}