import {ServiceType} from './ServiceType';
import {RentType} from './RentType';

export class Service {
  serviceId: number;
  serviceName: string;
  serviceArea: number;
  serviceCost: number;
  serviceMaxPerson: number;
  serviceStandardRoom: string;
  serviceDescription: string;
  servicePoolArea: number;
  serviceFloor: number;
  serviceType: ServiceType;
  rentType: RentType;
}
