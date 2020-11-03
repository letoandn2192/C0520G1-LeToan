import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../service/customer/customer.service';
import {CustomerTypeService} from '../../../service/customerType/customer-type.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Customer} from '../../../interface/Customer';
import {CustomerType} from '../../../interface/CustomerType';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerEditForm: FormGroup;
  customer: Customer;
  customerTypeList: CustomerType[] = [];
  // customerTypeIdSelected: number;

  constructor(private customerService: CustomerService, private customerTypeService: CustomerTypeService,
              private router: Router, private fb: FormBuilder, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.customerEditForm = this.fb.group({
        // customerId: '',
        customerName: ['', Validators.required],
        customerBirthday: ['', [Validators.required, Validators.pattern('^(?=\\d{2}([-.,\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$')]],
        customerGender: ['', Validators.required],
        customerIdCard: ['', [Validators.required, Validators.pattern('^((\\d{9})|(\\d{12}))$')]],
        customerPhone: ['', [Validators.required, Validators.pattern('^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$')]],
        customerEmail: ['', [Validators.required, Validators.pattern('^(\\w{3,}@\\w+\\.\\w+)$')]],
        customerAddress: ['', Validators.required],
        customerType: '',
      }
    );
    this.customerTypeService.getCustomerTypeList().subscribe(data => this.customerTypeList = data,
      error => this.customerTypeList = [],
      () => {
        const id = +this.route.snapshot.paramMap.get('id');
        this.customerService.getCustomerById(id)
          .subscribe(data => {
              this.customer = data;
              this.customerEditForm.patchValue(data);
              console.log(data);
            },
            error => this.customer = null, () => {
              // this.customerTypeIdSelected = this.customer.customerType.customerTypeId;
              for (const type of this.customerTypeList) {
                if (this.customer.customerType.customerTypeId === type.customerTypeId) {
                  this.customerEditForm.get('customerType').setValue(type);
                  break;
                }
              }
            });
      });
  }

  editCustomer() {
    if (this.customerEditForm.valid) {
      const {value} = this.customerEditForm;
      // fill value into customer
      const data = {...this.customer, ...value};
      this.customerService.updateCustomer(data).subscribe(next => this.router.navigate(['/customer']),
        error => console.log(error));
    }
  }
}
