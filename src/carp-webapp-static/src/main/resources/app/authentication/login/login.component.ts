import { Component } from '@angular/core'

import { Router, Routes, ROUTER_DIRECTIVES } from '@angular/router';

import {LoginService} from './login.service';

@Component({
    selector: 'login-tag',
    templateUrl: 'app/authentication/login/login.component.html',
    directives: [ROUTER_DIRECTIVES],
    providers: [LoginService]
})

export class LoginPage {
    error: any;

    constructor(
        private router: Router,
        private loginService: LoginService
    ){}

    login(event, email, password) {
        event.preventDefault();
        this.loginService
            .loginUser(email, password)
            .then(response =>{
                console.log(response);
                if(response.result == "USER_NOT_FOUND") {
                    alert(response.result);
                } else {
                    this.goHomePage();
                }
            })
            .catch(error => this.error = error);
    }

    private goHomePage(){
        this.router.navigate([`/homePage`]);
    }
}