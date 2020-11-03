import {Contract} from './Contract';
import {AttachService} from './AttachService';

export class ContractDetail {
  contractDetailId: number;
  contractDetailQuantity: number;
  contract: Contract;
  attachService: AttachService;
}
