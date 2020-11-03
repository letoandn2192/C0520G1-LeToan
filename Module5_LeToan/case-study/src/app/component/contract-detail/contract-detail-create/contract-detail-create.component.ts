import { Component, OnInit } from '@angular/core';
import {AttachService} from '../../../interface/AttachService';
import {FormBuilder, FormGroup} from '@angular/forms';
import {AttachServiceService} from '../../../service/attachService/attach-service.service';
import {ContractDetailService} from '../../../service/contractDetail/contract-detail.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ContractService} from '../../../service/contract/contract.service';
import {Contract} from '../../../interface/Contract';

@Component({
  selector: 'app-contract-detail-create',
  templateUrl: './contract-detail-create.component.html',
  styleUrls: ['./contract-detail-create.component.css']
})
export class ContractDetailCreateComponent implements OnInit {
  attachServiceList: AttachService[] = [];
  contractList: Contract[] = [];
  contractDetailCreateForm: FormGroup;
  constructor(private attachServiceService: AttachServiceService, private contractDetailService: ContractDetailService,
              private fb: FormBuilder, private route: ActivatedRoute, private contractService: ContractService,
              private router: Router) { }

  ngOnInit(): void {
    this.contractDetailCreateForm = this.fb.group({
      contractDetailQuantity: '',
      contract: '',
      attachService: ''
    });
    this.attachServiceService.getAttachServiceList()
      .subscribe(data => this.attachServiceList = data, error => this.attachServiceList = [] );
    this.contractService.getContractList().subscribe(data => this.contractList = data, error => this.contractList = []);
  }

  createContractDetail() {
    if (this.contractDetailCreateForm.valid) {
      const data = this.contractDetailCreateForm.value;
      console.log(data);
      this.contractDetailService.createNewContractDetail(data).subscribe(next => {
        this.router.navigate(['/contract']);
      }, error => console.log('error'));
    }
  }
}
