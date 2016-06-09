import { Component, Inject, NgZone , OnInit} from '@angular/core';
import { Routes, Router, ROUTER_DIRECTIVES } from '@angular/router';

import { LoginPage } from '../authentication/login/login.component';
import { LogoutPage } from '../authentication/logout/logout.component';
import { RegisterPage } from '../authentication/register/register.component';
import { HomePage } from '../home/home.component';
import { StartPage } from '../start-page/startPage.component';

@Component({
  selector: 'my-app',
  templateUrl: 'app/main-component/main.component.html',
  directives: [ROUTER_DIRECTIVES]
})

@Routes([
  {path: '/', component: StartPage},
  {path: '/loginPage', component: LoginPage},
  {path: '/homePage', component: HomePage},
  {path: '/registrationPage', component: RegisterPage},
  {path: '/logoutPage', component: LogoutPage}
])


export class AppComponent  implements OnInit {
  constructor(private router: Router, @Inject(Window) window: Window, ngZone:NgZone) {

    window.onresize = (e) => {
      ngZone.run(() => {
        this.isMenuExpanded = window.innerWidth < 768 ? false : true;
      })
    }

  }

  ngOnInit() {
    this.isMenuExpanded = window.innerWidth < 768 ? false : true;
  }

  title = 'Main Page CarPooling';
  isMenuExpanded = true;
}
