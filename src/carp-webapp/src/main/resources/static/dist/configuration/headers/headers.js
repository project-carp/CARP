"use strict";
var http_1 = require('@angular/http');
exports.contentHeaders = new http_1.Headers();
exports.contentHeaders.append('Accept', 'application/json');
exports.contentHeaders.append('Content-Type', 'application/json');
exports.contentHeadersUrlEncoded = new http_1.Headers();
exports.contentHeadersUrlEncoded.append('Accept', 'application/json');
exports.contentHeadersUrlEncoded.append('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
