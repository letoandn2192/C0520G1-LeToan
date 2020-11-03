import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {RentType} from '../../../interface/RentType';
import {ServiceType} from '../../../interface/ServiceType';
import {RentTypeService} from '../../../service/rentType/rent-type.service';
import {ServiceTypeService} from '../../../service/serviceType/service-type.service';
import {ServiceService} from '../../../service/service/service.service';

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {
  isVilla = true;
  isHouse = true;
  rentTypeList: RentType[] = [];
  serviceTypeList: ServiceType[] = [];
  serviceCreateForm: FormGroup;
  constructor(private rentTypeService: RentTypeService, private serviceTypeService: ServiceTypeService,
              private serviceService: ServiceService, private router: Router, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.serviceCreateForm = this.fb.group({
      serviceName: ['', Validators.required],
      serviceArea: ['', [Validators.required, Validators.pattern('') ]],
      serviceCost: ['', Validators.required],
      serviceMaxPerson: ['', [Validators.required, Validators.pattern('')]],
      serviceStandardRoom: [''],
      serviceDescription: [''],
      servicePoolArea: [''],
      serviceFloor: [''],
      serviceType: ['', Validators.required],
      rentType: ['', Validators.required],
    });
    this.rentTypeService.getRentTypeList()
      .subscribe(data => (this.rentTypeList = data), error => this.rentTypeList = []);
    this.serviceTypeService.getServiceTypeList()
      .subscribe(data => (this.serviceTypeList = data), error => this.serviceTypeList = []);
  }

  createNewService() {
    if (this.serviceCreateForm.valid) {
      const {value} = this.serviceCreateForm;
      console.log(value);
      this.serviceService.createNewService(value)
        .subscribe(data => { this.router.navigate(['/service']); }, error => console.log('error'));
    }
  }

  changeService(value: any) {
    if (value.serviceTypeId === 1) {
      this.isVilla = true;
      this.isHouse = true;
      console.log(this.serviceCreateForm);
    } else if (value.serviceTypeId === 2) {
      this.isVilla = false;
      this.isHouse = true;
      console.log(this.serviceCreateForm);
    } else {
      this.isVilla = false;
      this.isHouse = false;
      console.log(this.serviceCreateForm);
    }
  }
}
