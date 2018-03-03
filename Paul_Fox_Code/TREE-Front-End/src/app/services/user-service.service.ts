import { Injectable } from '@angular/core';
import { User } from '../domain/user';

@Injectable()
export class UserServiceService {

  constructor() { }

  user: User;

  setUser(email: string, password: string){

    this.user.email = email;
    this.user.password = password;

  }

  getUser(): User {

    return this.user;

  }

}
