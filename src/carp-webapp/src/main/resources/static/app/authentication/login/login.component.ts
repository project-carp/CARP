import { Component } from '@angular/core'

import { Router, Routes, ROUTER_DIRECTIVES } from '@angular/router';
import { Http } from '@angular/http';
import {contentHeadersUrlEncoded} from '../../configuration/headers/headers';

declare var Md5:any;

@Component({
    selector: 'login-tag',
    templateUrl: 'app/authentication/login/login.component.html',
    directives: [ROUTER_DIRECTIVES]
})

export class LoginPage {

    private loginUrl = 'login/carp';

    constructor(public router: Router, public http: Http) {
    }

    login(event, email, password) {
        event.preventDefault();
        var body = "email=" + email + "&password=" + Md5.hashStr(password);
        this.http.post(this.loginUrl, body, { headers: contentHeadersUrlEncoded })
            .subscribe(
                response => {
                    console.log(response);
                    if(response.json().result == "USER_NOT_FOUND") {
                        alert(response.json().result);
                    } else {
                        this.router.navigate([`/homePage`]);
                    }
                },
                error => {
                    alert(error.text());
                    console.log(error.text());
                }
            );
    }
}