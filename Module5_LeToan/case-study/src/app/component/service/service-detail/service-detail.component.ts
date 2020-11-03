import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Service} from '../../../interface/Service';
import {ServiceService} from '../../../service/service/service.service';

@Component({
  selector: 'app-service-detail',
  templateUrl: './service-detail.component.html',
  styleUrls: ['./service-detail.component.css']
})
export class ServiceDetailComponent implements OnInit {
  currentService: Service;
  constructor(private serviceService: ServiceService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.serviceService.getServiceById(id)
      .subscribe(data => this.currentService = data, error => { console.log(error); this.currentService = null; });
  }
}
