import { Component, OnInit } from '@angular/core';
import {Customer} from '../../../interface/Customer';
import {CustomerService} from '../../../service/customer/customer.service';
import {ActivatedRoute} from '@angular/router';
import {Contract} from '../../../interface/Contract';
import {ContractService} from '../../../service/contract/contract.service';

@Component({
  selector: 'app-contract-detail',
  templateUrl: './contract-detail.component.html',
  styleUrls: ['./contract-detail.component.css']
})
export class ContractDetailComponent implements OnInit {
  currentContract: Contract;
  constructor(private contractService: ContractService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.contractService.getContractById(id)
      .subscribe(data => this.currentContract = data, error => { console.log(error); this.currentContract = null; });
  }
}
