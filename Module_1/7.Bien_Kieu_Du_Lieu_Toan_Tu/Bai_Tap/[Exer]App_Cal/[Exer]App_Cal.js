let value1;
let value2;
function getValue() {
    value1 = document.getElementById('value1').value;
    value2 = document.getElementById('value2').value;
    if ((value1 == '') || (value2 == '')){
        alert('Nhập giá trị vào đi ahihi');
    }
}
function funcAdd() {
    getValue();
    let sum = value1*1 + value2*1;
    document.getElementById('result').innerHTML=('Result: '+ sum);
}
function funcSub() {
    getValue();
    let sub = value1 - value2;
    document.getElementById('result').innerHTML=('Result: '+ sub);
}
function funcMul() {
    getValue()
    let mul = value1 * value2;
    document.getElementById('result').innerHTML=('Result: '+ mul);
}
function funcDiv() {
    getValue();
    let div = value1 / value2;
    document.getElementById('result').innerHTML=('Result: '+ div);
}