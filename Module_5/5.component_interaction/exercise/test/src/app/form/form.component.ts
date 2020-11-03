import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, NgForm} from '@angular/forms';
export interface Subject {
  subjectId: number;
  subjectName: string;
}
@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  formSignUp: FormGroup;
  subjectList: Subject[] = [];
  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.subjectList = [
      {subjectId: 1, subjectName: 'NodeJS'},
      {subjectId: 2, subjectName: 'Angular'},
      {subjectId: 3, subjectName: 'ReactJS'}
    ];
    this.formSignUp = this.fb.group({
      email: 'letoandn2193@gmail.com',
      password: '',
      subject: this.subjectList[2]
    });
  }

  onSubmit() {
    console.log(this.formSignUp.value);
  }
}
