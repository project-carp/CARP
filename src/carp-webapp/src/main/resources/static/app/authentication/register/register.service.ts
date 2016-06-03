import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { contentHeaders } from '../../common/headers';

import {User} from '../user';



@Injectable()
export class RegisterService{
    email: string;


    private registrationUrl = 'app/registration';

    constructor(private http: Http){}


    registerNewUser(user: User): Promise<User> {
        let body = JSON.stringify({ user });

        return this.http
                   .post(this.registrationUrl, body, { headers: contentHeaders })
                   .toPromise()
                   .then(response => response.json().data)
                   .catch(this.handleError);
    }


    private handleError(error: any) {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}