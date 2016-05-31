import { Component } from '@angular/core'
import { Router } from '@angular/router-deprecated';
import { Http } from '@angular/http';
import { contentHeaders } from '../common/headers';

@Component({
    selector: 'login-tag',
    templateUrl: 'app/login/login.component.html',
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
                    this.router.parent.navigateByUrl('/homePage');
                },
                error => {
                    alert(error.text());
                    console.log(error.text());
                }
            );
    }
}