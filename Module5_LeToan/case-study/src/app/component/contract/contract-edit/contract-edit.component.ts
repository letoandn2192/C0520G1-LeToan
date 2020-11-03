import {Component, OnInit} from '@angular/core';
import {Customer} from '../../../interface/Customer';
import {Employee} from '../../../interface/Employee';
import {Service} from '../../../interface/Service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ContractService} from '../../../service/contract/contract.service';
import {CustomerService} from '../../../service/customer/customer.service';
import {EmployeeService} from '../../../service/employee/employee.service';
import {ServiceService} from '../../../service/service/service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Contract} from '../../../interface/Contract';

@Component({
  selector: 'app-contract-edit',
  templateUrl: './contract-edit.component.html',
  styleUrls: ['./contract-edit.component.css']
})
export class ContractEditComponent implements OnInit {
  customerList: Customer[] = [];
  employeeList: Employee[] = [];
  serviceList: Service[] = [];
  contract: Contract;
  contractEditForm: FormGroup;

  constructor(private contractService: ContractService, private customerService: CustomerService,
              private employeeService: EmployeeService, private serviceService: ServiceService,
              private router: Router, private fb: FormBuilder, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.contractEditForm = this.fb.group({
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
    this.serviceService.getServiceList().subscribe(data => this.serviceList = data, error => this.serviceList = [], () => {
      const id = +this.route.snapshot.paramMap.get('id');
      this.contractService.getContractById(id)
        .subscribe(data => {
            this.contract = data;
            this.contractEditForm.patchValue(data);
            console.log(data);
          }
          , error => console.log(error), () => {
            for (const employee of this.employeeList) {
              if (employee.employeeId === this.contract.employee.employeeId) {
                this.contractEditForm.get('employee').setValue(employee);
                break;
              }
            }
            for (const customer of this.customerList) {
              if (customer.customerId === this.contract.customer.customerId) {
                this.contractEditForm.get('customer').setValue(customer);
                break;
              }
            }
            for (const service of this.serviceList) {
              if (service.serviceId === this.contract.service.serviceId) {
                this.contractEditForm.get('service').setValue(service);
                break;
              }
            }
          });
    });
  }

  updateContract() {
    if (this.contractEditForm.valid) {
      const {value} = this.contractEditForm;
      const data = {...this.contract, ...value};
      console.log(value);
      this.contractService.createNewContract(value)
        .subscribe(next => {
          this.router.navigate(['/contract']);
        }, error => console.log('error'));
    }
  }
}
