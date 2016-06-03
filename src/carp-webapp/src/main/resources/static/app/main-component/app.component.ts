import { Component, OnInit } from '@angular/core';
import { Routes, Router, ROUTER_DIRECTIVES } from '@angular/router';

import { LoginPage } from '../authentication/login/login.component';
import { RegisterPage } from '../authentication/register/register.component';
import { HomePage } from '../home/home.component';

@Component({
  selector: 'my-app',
  templateUrl: 'app/main-component/main.component.html',
  directives: [ROUTER_DIRECTIVES]
})

@Routes([
  {path: '/loginPage', component: LoginPage},
  {path: '/homePage', component: HomePage},
  {path: '/registrationPage', component: RegisterPage}
])


export class AppComponent {
  constructor(private router: Router) {}

  title = 'Main Page CarPooling';
}
