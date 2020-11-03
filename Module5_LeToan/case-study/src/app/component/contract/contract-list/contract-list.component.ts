import { Component, OnInit } from '@angular/core';
import {Contract} from '../../../interface/Contract';
import {ContractService} from '../../../service/contract/contract.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contractList: Contract[] = [];
  page = 1;
  filter = '';
  key = 'contractId';
  reverse = false;
  constructor(private contractService: ContractService, private router: Router) {
  }

  ngOnInit(): void {
    this.contractService.getContractList().subscribe(data => (this.contractList = data), error => this.contractList = error);
  }

  deleteContract(i: number) {
    this.contractService.deleteContract(i).subscribe(data => {
      this.router.navigate(['/contract']);
    }, error => console.log('error'));
  }

  sort(key){
    console.log(this.contractList);
    this.key = key;
    this.reverse = !this.reverse;
  }
}
