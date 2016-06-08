import { Headers } from '@angular/http';

export const contentHeaders = new Headers();
contentHeaders.append('Accept', 'application/json');
contentHeaders.append('Content-Type', 'application/json');

export const contentHeadersUrlEncoded = new Headers();
contentHeadersUrlEncoded.append('Accept', 'application/json');
contentHeadersUrlEncoded.append('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');