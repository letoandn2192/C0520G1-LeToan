import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {Student} from "../model.students";

@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html',
  styleUrls: ['./template-driven-form.component.css']
})
export class TemplateDrivenFormComponent implements OnInit {

  public student: Student = new Student("", 0);

  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmitForm(createForm: NgForm) {
    if (createForm.valid) {
      console.log(createForm.value)
    } else {
      console.log("Loi roi ban oi");
    }
  }

  onResetForm(createForm: NgForm) {
    createForm.reset();
  }
}
