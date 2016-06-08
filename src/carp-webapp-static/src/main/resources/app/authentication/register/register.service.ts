import { Injectable }    from '@angular/core';
import { Headers, Http, Response } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import { Md5 } from 'ts-md5/dist/md5';

import { contentHeaders } from '../../configuration/headers/headers';
import { AppSettings } from '../../configuration/app-settings/app.settings'
import  {User } from '../user';
import  {RestResponse } from '../../response';

@Injectable()
export class RegisterService{
    email: string;

    constructor(private http: Http){}

    registerNewUser(user: User): Promise<RestResponse> {
        let body = JSON.stringify({ userName:user.userName, password:Md5.hashStr(user.password) });
        let url = `${AppSettings.API_ENDPOINT}/register`;

        return this.http
                   .post(url, body, { headers: contentHeaders })
                   .toPromise()
                   .then(this.extractData)
                   .catch(this.handleError);
    }


    private extractData(res: Response) {
        let body = res.json();
        return body;
    }

    private handleError(error: any) {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}