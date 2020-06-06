let value1;
let value2;
function funcCalcu(operator) {
    value1 = document.getElementById('value1').value;
    value2 = document.getElementById('value2').value;
    if ((value1 == '') || (value2 == '')) {
        alert('Nhập giá trị vào đi ahihi');
    }else{
    switch (operator) {
        case '+':
            let sum = 1 * value1 + 1 * value2;
            document.getElementById('result').innerHTML = ('Result:' + sum);
            break;
        case '-':
            let sub = value1 - value2;
            document.getElementById('result').innerHTML = ('Result: ' + sub);
            break;
        case '*':
            let mul = value1 * value2;
            document.getElementById('result').innerHTML = ('Result: ' + mul);
            break;
        case "/":
            let div = value1 / value2;
            document.getElementById('result').innerHTML = ('Result: ' + div);
            break;
    }
    }
}
