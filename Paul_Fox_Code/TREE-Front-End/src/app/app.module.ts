import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
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
import { AppRoutingModule } from './/app-routing.module';
import { FormComponent } from './form/form.component';
import { FormService } from './services/form.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    HeaderComponent,
    DashboardComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [UserServiceService, AuthGuard, EmployeeService, FormService],
  bootstrap: [AppComponent]
})
export class AppModule { }
