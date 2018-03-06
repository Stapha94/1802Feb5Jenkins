import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../domain/employee';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(
    private router: Router, 
    private employeeService: EmployeeService,
  
  ) { }

  employee: Employee;

  ngOnInit() {
    this.employee = this.employeeService.getEmployee();
    console.log(this.employee.firstName);
  }



}
