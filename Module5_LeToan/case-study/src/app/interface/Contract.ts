import {Employee} from './Employee';
import {Customer} from './Customer';
import {Service} from './Service';

export class Contract {
  contractId: number;
  contractStartDate: string;
  contractEndDate: string;
  contractDeposit: number;
  contractTotalMoney: number;
  employee: Employee;
  customer: Customer;
  service: Service;
}
