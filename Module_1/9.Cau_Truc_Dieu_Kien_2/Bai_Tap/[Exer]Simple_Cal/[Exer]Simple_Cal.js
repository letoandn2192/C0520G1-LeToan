function addNumber(arg){
    if (arg == '='){
        doCalculate();
    }else if(arg == 'C'){
        document.getElementById('text').value = '';
    }else{
        document.getElementById('text').value += arg;
    }
}

function doCalculate() {
    let exp = document.getElementById('text').value;
    document.getElementById('text').value = eval(exp);
}
