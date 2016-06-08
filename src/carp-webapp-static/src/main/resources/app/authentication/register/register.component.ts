import { Component } from '@angular/core';
import { Router, Routes, ROUTER_DIRECTIVES } from '@angular/router';

import {Md5} from 'ts-md5/dist/md5'

import {User} from '../user';
import {RegisterService} from './register.service';



@Component({
    selector: 'register-tag',
    templateUrl: 'app/authentication/register/register.component.html',
    directives: [ROUTER_DIRECTIVES],
    providers: [RegisterService]
})

export class RegisterPage{
    error: any;

    constructor(
        private router: Router,
        private registerService: RegisterService
    ){}

    addNerUser(email, password){
        var user = new User(email, password);
        this.registerUser(user);
    }

    registerUser(user){
        this.registerService
            .registerNewUser(user)
            .then(response =>{
                console.log(response.status);
                this.goHomePage();
            })
            .catch(error => this.error = error);
    }

    private goHomePage(){
        this.router.navigate([`/homePage`]);
    }
}