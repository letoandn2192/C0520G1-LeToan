import { Component, OnInit } from '@angular/core';
import {Employee} from '../../../interface/Employee';
import {ActivatedRoute} from '@angular/router';
import {EmployeeService} from '../../../service/employee/employee.service';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {
  currentEmployee: Employee;
  constructor(private employeeService: EmployeeService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.employeeService.getEmployeeById(id)
      .subscribe(data => this.currentEmployee = data, error => { console.log(error); this.currentEmployee = null; });
  }

}
