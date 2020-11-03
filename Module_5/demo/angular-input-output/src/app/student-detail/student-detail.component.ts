import {Component, Input, OnInit} from '@angular/core';
import {Student} from "../model.students";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  @Input('student') studentDetail:Student;
  constructor() { }

  ngOnInit(): void {
  }

}
