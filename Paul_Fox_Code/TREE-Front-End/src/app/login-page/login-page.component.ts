import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../user';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  user = new User("", "");

  login(){

    if(this.user.email === 'test@test.test' && this.user.password === "password"){
      this.router.navigate(['dashboard']);
    }
    else{
      alert("Incorrect Email or Password");
    }

  }

  get diagnostic() {return JSON.stringify(this.user)}

}
