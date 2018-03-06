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
  employee: Employee;

  data: {};

  login(){

    // if(this.user.email === 'test@test.test' && this.user.password === "password"){
    //   this.router.navigate(['dashboard']);
    // }
    // else{
    //   alert("Incorrect Email or Password");
    // }

    console.log(this.user.email);
    console.log(this.user.password);
    this.http.post('http://localhost:8080/tree/login-info', {
      email: this.user.email,
      password: this.user.password
    }).subscribe(
      data =>
      //console.log(data));
      this.data = data);
    console.log(this.data);
    this.employee = JSON.parse(JSON.stringify(this.data));
    if(this.employee.email != null){
      this.employeeService.logIn();
    }
    if(this.employeeService.isLoggedIn){
      this.router.navigate(['dashboard']);
    }
    else{
      alert("Incorrect Email or Password");
    }

  }

  get diagnostic() {return JSON.stringify(this.user)}

}
