import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { EmployeeService } from '../services/employee.service';

@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private employeeService: EmployeeService, private router: Router) {}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (this.employeeService.getIsLoggedIn()){

      return true;

    }
    else{

      this.router.navigate(['login'])
      return false;

    }
  }
}
