let inputWidth;
let inputHeight;

inputWidth = prompt('Nhập chiều rộng hcn:');
inputHeight = prompt('Nhập chiều cao hcn:');

// let width = parseInt(inputWidth);
// let height = parseInt(inputHeight);
let area = inputHeight * inputWidth;

document.write('Diện Tích HCN là: '+ area);
document.write('<br/>');
// document.write(inputHeight);
// document.write('<br/>');
document.write(typeof area);