import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { contentHeaders } from '../../configuration/headers/headers';
import { AppSettings } from '../../configuration/app-settings/app.settings'
import {User} from '../user';

declare var Md5:any;

@Injectable()
export class RegisterService{
    email: string;

    constructor(private http: Http){}

    registerNewUser(user: User): Promise<User> {
        let body = JSON.stringify({ userName:user.userName, password:Md5.hashStr(user.password) });
        let url = `${AppSettings.API_ENDPOINT}/register`;

        return this.http
                   .post(url, body, { headers: contentHeaders })
                   .toPromise()
                   .then(response => response.json().data)
                   .catch(this.handleError);
    }


    private handleError(error: any) {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}