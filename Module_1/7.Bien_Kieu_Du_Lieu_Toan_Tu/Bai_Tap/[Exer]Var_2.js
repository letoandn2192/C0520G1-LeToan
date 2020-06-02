let Tempc = prompt('Nhập nhiệt độ C:');
let TempC = parseInt(Tempc);
let TempF = (9 * TempC)/5 + 32;
document.write('Giá trị độ F là: '+ TempF);
document.getElementById('tempF').innerHTML=('Giá Trị Độ F là: '+ TempF);