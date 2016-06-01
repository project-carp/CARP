import { Component } from '@angular/core'
import { Router } from '@angular/router-deprecated';

@Component({
    selector: 'home-tag',
    templateUrl: 'app/home/home.component.html',
})

export class HomePage {
    constructor(public router: Router) {
    }
}