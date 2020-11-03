import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from "../model.students";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {

  @Output('student') onCreate = new EventEmitter<Student>();

  private  _student: Student;
  constructor() { }

  ngOnInit(): void {
  }

  onClick(name: string, age: number) {
    this._student = new Student(name, age);
    console.log(this._student);
    this.onCreate.emit(this._student);
  }
}
