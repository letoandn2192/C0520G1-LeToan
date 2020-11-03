import { Component, OnInit } from '@angular/core';
import {Employee} from '../../../interface/Employee';
import {EmployeeService} from '../../../service/employee/employee.service';
import {Customer} from '../../../interface/Customer';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employeeList: Employee[] = [];
  page = 1;
  filter = '';
  key = 'employeeId';
  reverse = false;
  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.employeeService.getEmployeeList().subscribe(data => this.employeeList = data, error => this.employeeList = []);
  }

  deleteEmployee(i: number) {
    this.employeeService.deleteEmployee(i).subscribe(data => {
      this.router.navigate(['/customer']);
    }, error => console.log('error'));
  }

  sort(key: string) {
    console.log(this.employeeList);
    this.key = key;
    this.reverse = !this.reverse;
  }
}
