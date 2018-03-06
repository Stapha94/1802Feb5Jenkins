import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { HeaderComponent } from './header/header.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserServiceService } from './services/user-service.service';
import { AuthGuard } from './guards/auth.guard';
import { EmployeeService } from './services/employee.service';


const appRoutes:Routes = [
  {
    path: 'login',
    component: LoginPageComponent
  },

  {
    path: 'dashboard',
    canActivate: [AuthGuard],
    component: DashboardComponent
  },

  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  }
]

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    HeaderComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpClientModule
  ],
  providers: [UserServiceService, AuthGuard, EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
