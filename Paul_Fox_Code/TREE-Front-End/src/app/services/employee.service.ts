import { Injectable } from '@angular/core';
import { Employee } from '../domain/employee';

@Injectable()
export class EmployeeService {

  constructor() { }

  employee: Employee = new Employee("","","");

  isLoggedIn: boolean = false;

  logIn(): void {

    this.isLoggedIn = true;

  }

  getIsLoggedIn(): boolean {

    return this.isLoggedIn;

  }

}
