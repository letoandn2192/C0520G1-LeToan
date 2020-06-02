let Physical = prompt('Nhập điểm lí: ');
let Chemiscal = prompt('Nhập điểm hóa: ');
let Biology = prompt('Nhập điểm sinh: ');

let Phy = parseInt(Physical);
let Che = parseInt(Chemiscal);
let Bio = parseInt(Biology);

let avg = (Phy + Che + Bio)/3;
let sum = Phy + Che + Bio;

document.write('Điểm Trung Bình 3 Môn là: '+ avg);
document.write('<br/>');
document.write('Tổng Điểm 3 Môn là: '+ sum);

