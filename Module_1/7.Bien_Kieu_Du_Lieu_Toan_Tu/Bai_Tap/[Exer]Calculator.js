function insert(number) {
    document.getElementById('text').value += number;
}
function equal() {
    let value = document.getElementById('text').value;
    // if (0){
        document.getElementById('text').value = eval(value);
    // }
}