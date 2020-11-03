import { Component, OnInit } from '@angular/core';
import {Division} from '../../../interface/Division';
import {Position} from '../../../interface/Position';
import {EducationDegree} from '../../../interface/EducationDegree';
import {Employee} from '../../../interface/Employee';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DivisionService} from '../../../service/division/division.service';
import {PositionService} from '../../../service/position/position.service';
import {EducationDegreeService} from '../../../service/educationDegree/education-degree.service';
import {Router} from '@angular/router';
import {EmployeeService} from '../../../service/employee/employee.service';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  divisionList: Division[] = [];
  positionList: Position[] = [];
  educationDegreeList: EducationDegree[] = [];
  employeeCreateForm: FormGroup;
  constructor(private divisionService: DivisionService, private positionService: PositionService,
              private educationDegreeService: EducationDegreeService, private router: Router,
              private fb: FormBuilder, private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeCreateForm = this.fb.group({
      employeeName: ['', Validators.required],
      employeeBirthday: ['', [Validators.required, Validators.pattern('^(?=\\d{2}([-.,\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$')]],
      employeeIdCard: ['', [Validators.required, Validators.pattern('^((\\d{9})|(\\d{12}))$')]],
      employeeSalary: [0, Validators.required],
      employeePhone: ['', [Validators.required, Validators.pattern('^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$')]],
      employeeEmail: ['', [Validators.required, Validators.pattern('^(\\w{3,}@\\w+\\.\\w+)$')]],
      employeeAddress: ['', Validators.required],
      position: '',
      division: '',
      educationDegree: ''
    });
    this.divisionService.getDivisionList().subscribe(data => this.divisionList = data, error => this.divisionList = []);
    this.positionService.getPositionList().subscribe(data => this.positionList = data, error => this.positionList= []);
    this.educationDegreeService.getEducationDegreeList()
      .subscribe(data => this.educationDegreeList = data, error => this.educationDegreeList = []);
  }

  createNewEmployee() {
    if (this.employeeCreateForm.valid) {
      const {value} = this.employeeCreateForm;
      console.log(value);
      this.employeeService.createNewEmployee(value)
        .subscribe(data => {
          this.router.navigate(['/employee']);
        }, error => console.log('error'));
    }
  }
}
