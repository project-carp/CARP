import { Component, OnInit } from '@angular/core'

import { Router, Routes, ROUTER_DIRECTIVES } from '@angular/router';
import { Http } from '@angular/http';


@Component({
    selector: 'logout-tag',
    templateUrl: 'app/authentication/logout/logout.component.html',
    directives: [ROUTER_DIRECTIVES]
})



export class LogoutPage implements OnInit{

    constructor(public router: Router, public http: Http) {
    }

    ngOnInit() {

        this.http.get('http://localhost:18080/logout')
            .subscribe(
                response => {
                    console.log(response);
                },
                error => {
                    alert(error.text());
                    console.log(error.text());
                }
            );
    }

}