import {Division} from './Division';
import {Position} from './Position';
import {EducationDegree} from './EducationDegree';

export class Employee {
  employeeId: number;
  employeeName: string;
  employeeBirthday: string;
  employeeIdCard: string;
  employeeSalary: number;
  employeePhone: string;
  employeeEmail: string;
  employeeAddress: string;
  position: Position;
  division: Division;
  educationDegree: EducationDegree;
}
