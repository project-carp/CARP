import { Component, OnInit } from '@angular/core';
import { Routes, Router, ROUTER_DIRECTIVES } from '@angular/router';

import { LoginPage } from '../login/login.component';

@Component({
  selector: 'my-app',
  templateUrl: 'app/main-component/main.component.html',
  directives: [ROUTER_DIRECTIVES]
})


@Routes([
  {path: '/loginPage', component: LoginPage}
])


export class AppComponent {
  constructor(private router: Router) {}

  title = 'Main Page CarPooling';
}
