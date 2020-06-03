let amount;
let fromCurrency;
let toCurrency;
let rateUSD_VND = 23000;
let rateEUR_VND = 25000;
let rateEUR_USD = 1.117;
let date = new Date().getF

function exchangeMoney() {
    amount = document.getElementById('amount').value;
    fromCurrency = document.getElementById('fromcurrency').value;
    toCurrency = document.getElementById('tocurrency').value;
    if (fromCurrency == 'VND'){
        switch (toCurrency) {
            case 'VND':
                break;
            case 'USD':
                amount = amount / rateUSD_VND;
                break;
            case 'EUR':
                amount = amount / rateEUR_VND;
                break;
        }
        document.getElementById('result0').innerHTML = ('Result: '+ amount +' '+ toCurrency);
    } else if (fromCurrency == 'USD') {
        switch (toCurrency) {
            case 'VND':
                amount = amount * rateUSD_VND;
                break;
            case 'USD':
                break;
            case 'EUR':
                amount = amount / rateEUR_USD;
                break;
        }
        document.getElementById('result0').innerHTML = ('Result: '+ amount +' '+ toCurrency);
    } else{
        switch (toCurrency) {
            case 'VND':
                amount = amount * rateEUR_VND;
                break;
            case 'USD':
                amount = amount * rateEUR_USD;
                break;
            case 'EUR':
                break;
        }
        document.getElementById('result0').innerHTML = ('Result: '+ amount +' '+ toCurrency);
    }
}