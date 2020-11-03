import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../service/customer/customer.service';
import {Router} from '@angular/router';
import {Customer} from '../../../interface/Customer';
import {Employee} from '../../../interface/Employee';
import {Service} from '../../../interface/Service';
import {EmployeeService} from '../../../service/employee/employee.service';
import {ServiceService} from '../../../service/service/service.service';
import {ContractService} from '../../../service/contract/contract.service';

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {
  customerList: Customer[] = [];
  employeeList: Employee[] = [];
  serviceList: Service[] = [];
  contractCreateForm: FormGroup;

  constructor(private contractService: ContractService, private customerService: CustomerService,
              private employeeService: EmployeeService, private serviceService: ServiceService,
              private router: Router, private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.contractCreateForm = this.fb.group({
      contractStartDate: ['', [Validators.required, Validators.pattern('^(?=\\d{2}([-.,\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$')]],
      contractEndDate: ['', [Validators.required, Validators.pattern('^(?=\\d{2}([-.,\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$')]],
      contractDeposit: ['', [Validators.required, Validators.pattern('')]],
      contractTotalMoney: ['', [Validators.required, Validators.pattern('')]],
      employee: '',
      customer: '',
      service: '',
    });
    this.customerService.getCustomerList().subscribe(data => this.customerList = data, error => this.customerList = []);
    this.employeeService.getEmployeeList().subscribe(data => this.employeeList = data, error => this.employeeList = []);
    this.serviceService.getServiceList().subscribe(data => this.serviceList = data, error => this.serviceList = []);
  }

  createNewContract() {
    if (this.contractCreateForm.valid) {
      const {value} = this.contractCreateForm;
      console.log(value);
      this.contractService.createNewContract(value)
        .subscribe(data => {
          this.router.navigate(['/contract']);
        }, error => console.log('error'));
    }
  }
}
