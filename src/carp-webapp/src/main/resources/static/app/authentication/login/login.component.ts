import { Component } from '@angular/core'

import { Router, Routes, ROUTER_DIRECTIVES } from '@angular/router';
import { Http } from '@angular/http';
import { contentHeaders } from '../../configuration/headers/headers';
import { AppSettings } from '../../configuration/app-settings/app.settings'


@Component({
    selector: 'login-tag',
    templateUrl: 'app/authentication/login/login.component.html',
    directives: [ROUTER_DIRECTIVES]
})



export class LoginPage {

    constructor(public router: Router, public http: Http) {
    }

    login(event, email, password) {
        event.preventDefault();
        let body = JSON.stringify({ email, password });
        this.http.post('http://localhost:18080/login/carp', body, { headers: contentHeaders })
            .subscribe(
                response => {
                    console.log(response);
                    this.router.navigate([`/homePage`]);
                },
                error => {
                    alert(error.text());
                    console.log(error.text());
                }
            );
    }
}