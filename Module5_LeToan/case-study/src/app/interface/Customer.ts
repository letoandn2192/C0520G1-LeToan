import {CustomerType} from './CustomerType';

export interface Customer {
  customerId: number;
  customerName: string;
  customerBirthday: string;
  customerGender: boolean;
  customerIdCard: string;
  customerPhone: string;
  customerEmail: string;
  customerAddress: string;
  customerType: CustomerType;
}
