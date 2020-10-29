import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  // title = 'hello-angular';
  title = 'First Angular';
  fontSize = 18;
  petName = 'puppie';
  petImage = 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg';
  firstOperand: number = 0;
  secondOperand: number = 0;
  operator: string = "*";
  output: number;
  error: string;
  fontColor = "red";
  constructor() { }
  onChange(value) {
    this.fontSize = value;
  }
  ngOnInit() {
  }

  updateName(name: string) {
    this.petName = name;
  }

  updateImage(image: string) {
    this.petImage = image;
  }

  updateFirstOperand(value: number) {
    this.firstOperand = value;
  }

  updateOperator(value: string) {
    this.operator = value;
  }

  updateSecondOperand(value: number) {
    this.secondOperand = value
  }

  calculate() {
    this.error = "";
    switch (this.operator) {
      case "+":
        this.output = 1 * this.firstOperand + 1 * this.secondOperand;
        break;
      case "-":
        this.output = this.firstOperand - this.secondOperand;
        break;
      case "*":
        this.output = this.firstOperand * this.secondOperand;
        break;
      case "/":
        if (this.secondOperand != 0) {
          this.output = this.firstOperand / this.secondOperand;
        } else {
          this.error = "Divide for Zero!!!"
        }
        break;
    }
  }

  onChangeColor(value: string) {
    this.fontColor = value;
  }
}
