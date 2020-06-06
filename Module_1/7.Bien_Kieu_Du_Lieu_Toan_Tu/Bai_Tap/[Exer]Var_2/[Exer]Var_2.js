let Tempc = prompt('Nhập nhiệt độ C:');
document.write(typeof Tempc);
// let TempC = parseInt(Tempc);
let TempF = (9 * Tempc)/5 + 32;
document.write('Giá trị độ F là: '+ TempF);
document.getElementById('tempF').innerHTML=('Giá Trị Độ F là: '+ TempF);