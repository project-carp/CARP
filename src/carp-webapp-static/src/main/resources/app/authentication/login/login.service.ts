import { Injectable }    from '@angular/core';
import { Http, Response } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import { Md5 } from 'ts-md5/dist/md5';

import { contentHeadersUrlEncoded } from '../../configuration/headers/headers';
import { AppSettings } from '../../configuration/app-settings/app.settings'
import  {LoginResponse } from './loginResponse';

@Injectable()
export class LoginService{
    private loginUrl = `${AppSettings.API_ENDPOINT}/login/carp`;

    constructor(private http: Http){}

    loginUser(email: string, password: string): Promise<LoginResponse> {
        var body = "email=" + email + "&password=" + Md5.hashStr(password);
        return this.http.post(this.loginUrl, body, { headers: contentHeadersUrlEncoded })
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