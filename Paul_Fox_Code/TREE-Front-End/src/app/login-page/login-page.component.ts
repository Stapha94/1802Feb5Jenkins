import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import { User } from '../domain/user';
import { UserServiceService } from '../services/user-service.service';
import { Employee } from '../domain/employee';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(
    private router:Router, 
    private userService: UserServiceService,
    private http: HttpClient,
    private employeeService: EmployeeService
  ) { }

  ngOnInit() {
    
  }

  user: User = new User("", "");

  login(){

    this.http.post('http://localhost:8080/tree/login-info', {
      email: this.user.email,
      password: this.user.password
    }).subscribe(
      data => {
      let a = JSON.parse(JSON.stringify(data));
      this.employeeService.employee.firstName = a.firstName;
      this.employeeService.employee.lastName = a.lastName;
      this.employeeService.employee.email = a.email;
      if(this.employeeService.employee.email != null){
        this.employeeService.logIn();
      }
      if(this.employeeService.isLoggedIn){
        this.router.navigate(['dashboard']);
      }
      else{
        alert("Incorrect Email or Password");
      }
    });
    

  }

  get diagnostic() {return JSON.stringify(this.user)}

}
