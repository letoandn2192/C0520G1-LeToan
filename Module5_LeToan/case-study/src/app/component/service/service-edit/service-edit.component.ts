import {Component, OnInit} from '@angular/core';
import {RentType} from '../../../interface/RentType';
import {ServiceType} from '../../../interface/ServiceType';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {RentTypeService} from '../../../service/rentType/rent-type.service';
import {ServiceTypeService} from '../../../service/serviceType/service-type.service';
import {ServiceService} from '../../../service/service/service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Service} from '../../../interface/Service';

@Component({
  selector: 'app-service-edit',
  templateUrl: './service-edit.component.html',
  styleUrls: ['./service-edit.component.css']
})
export class ServiceEditComponent implements OnInit {
  isVilla = true;
  isHouse = true;
  service: Service;
  rentTypeList: RentType[] = [];
  serviceTypeList: ServiceType[] = [];
  serviceEditForm: FormGroup;

  constructor(private rentTypeService: RentTypeService, private serviceTypeService: ServiceTypeService,
              private serviceService: ServiceService, private router: Router, private fb: FormBuilder,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.serviceEditForm = this.fb.group({
      serviceName: ['', Validators.required],
      serviceArea: ['', [Validators.required, Validators.pattern('')]],
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
      .subscribe(data => (this.serviceTypeList = data), error => this.serviceTypeList = [], () => {
        const id = +this.route.snapshot.paramMap.get('id');
        this.serviceService.getServiceById(id)
          .subscribe(data => {
              this.service = data;
              this.serviceEditForm.patchValue(data);
              console.log(data);
            },
            error => this.service = null, () => {
              for (const rentType of this.rentTypeList) {
                if (rentType.rentTypeId === this.service.rentType.rentTypeId) {
                  this.serviceEditForm.get('rentType').setValue(rentType);
                  break;
                }
              }
              for (const serviceType of this.serviceTypeList) {
                if (serviceType.serviceTypeId === this.service.serviceType.serviceTypeId) {
                  this.serviceEditForm.get('serviceType').setValue(serviceType);
                  break;
                }
              }
            });
      });

  }

  updateService() {
    if (this.serviceEditForm.valid) {
      const {value} = this.serviceEditForm;
      // fill value into customer
      const data = {...this.service, ...value};
      console.log(value);
      this.serviceService.updateService(data)
        .subscribe(next => {
          this.router.navigate(['/service']);
        }, error => console.log('error'));
    }
  }

  changeService(value: any) {
    if (value.serviceTypeId === 1) {
      this.isVilla = true;
      this.isHouse = true;
    } else if (value.serviceTypeId === 2) {
      this.isVilla = false;
      this.isHouse = true;
    } else {
      this.isVilla = false;
      this.isHouse = false;
    }
  }
}
