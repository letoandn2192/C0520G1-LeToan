import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../../service/customer/customer.service';
import {Router} from '@angular/router';
import {Service} from '../../../interface/Service';
import {ServiceService} from '../../../service/service/service.service';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  serviceList: Service[] = [];
  page = 1;
  filter = '';
  key = 'serviceId';
  reverse = false;
  constructor(private serviceService: ServiceService, private router: Router) {
  }

  ngOnInit(): void {
    this.serviceService.getServiceList().subscribe(data => (this.serviceList = data), error => this.serviceList = error);
  }

  deleteService(i: number) {
    this.serviceService.deleteService(i).subscribe(data => {
      this.router.navigate(['/service']);
    }, error => console.log('error'));
  }

  sort(key){
    this.key = key;
    this.reverse = !this.reverse;
  }
}
