import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Employee} from '../../../interface/Employee';
import {Division} from '../../../interface/Division';
import {EducationDegree} from '../../../interface/EducationDegree';
import {Position} from '../../../interface/Position';
import {ActivatedRoute, Router} from '@angular/router';
import {EmployeeService} from '../../../service/employee/employee.service';
import {PositionService} from '../../../service/position/position.service';
import {EducationDegreeService} from '../../../service/educationDegree/education-degree.service';
import {DivisionService} from '../../../service/division/division.service';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  employeeEditForm: FormGroup;
  employee: Employee;
  divisionList: Division[] = [];
  educationDegreeList: EducationDegree[] = [];
  positionList: Position[] = [];
  // divisionIdSelected: number;
  // positionIdSelected: number;
  // educationIdSelected: number;
  constructor(private employeeService: EmployeeService, private positionService: PositionService,
              private educationDegreeService: EducationDegreeService, private divisionService: DivisionService,
              private router: Router, private fb: FormBuilder, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.employeeEditForm = this.fb.group({
        employeeName: ['', Validators.required],
        employeeBirthday: ['', [Validators.required, Validators.pattern('^(?=\\d{2}([-.,\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$') ]],
        employeeIdCard: ['', [Validators.required, Validators.pattern('^((\\d{9})|(\\d{12}))$')]],
        employeeSalary: ['', Validators.required],
        employeePhone: ['', [Validators.required, Validators.pattern('^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$')]],
        employeeEmail: ['', [Validators.required, Validators.pattern('^(\\w{3,}@\\w+\\.\\w+)$')]],
        employeeAddress: ['', Validators.required],
        position: '',
        division: '',
        educationDegree: '',
      }
    );
    this.positionService.getPositionList().subscribe(data => this.positionList = data, error => this.positionList = []);
    this.divisionService.getDivisionList().subscribe(data => this.divisionList = data, error => this.divisionList = []);
    this.educationDegreeService.getEducationDegreeList().subscribe(data => this.educationDegreeList = data,
        error => this.educationDegreeList = [],
      () => {
        const id = +this.route.snapshot.paramMap.get('id');
        this.employeeService.getEmployeeById(id)
          .subscribe(data => {this.employee = data; this.employeeEditForm.patchValue(data); },
            error => this.employee = null, () => {
              for (const division of this.divisionList) {
                if (division.divisionId === this.employee.division.divisionId) {
                  this.employeeEditForm.get('division').setValue(division);
                  break;
                }
              }
              for (const position of this.positionList) {
                if (position.positionId === this.employee.position.positionId) {
                  this.employeeEditForm.get('position').setValue(position);
                  break;
                }
              }
              for (const education of this.educationDegreeList) {
                if (education.educationDegreeId === this.employee.educationDegree.educationDegreeId) {
                  this.employeeEditForm.get('educationDegree').setValue(education);
                  break;
                }
              }
            });
            });
  }

  editEmployee() {
    if (this.employeeEditForm.valid) {
      const {value} = this.employeeEditForm;
      // fill value into employee
      const data = {...this.employee, ...value};
      console.log(data);
      this.employeeService.updateEmployee(data).subscribe(next => this.router.navigate(['/employee']),
        error => console.log(error));
    }
  }

}
