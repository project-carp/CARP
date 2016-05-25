import { Component } from '@angular/core'
import { Router } from '@angular/router-deprecated';

@Component({
    selector: 'login-tag',
    templateUrl: 'app/login/login.component.html',
})

export class LoginPage {
    constructor(
        private router: Router
    ){}
}