"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var router_1 = require('@angular/router');
var http_1 = require('@angular/http');
var headers_1 = require('../../configuration/headers/headers');
var LoginPage = (function () {
    function LoginPage(router, http) {
        this.router = router;
        this.http = http;
        this.loginUrl = 'login/carp';
    }
    LoginPage.prototype.login = function (event, email, password) {
        var _this = this;
        event.preventDefault();
        var body = "email=" + email + "&password=" + Md5.hashStr(password);
        this.http.post(this.loginUrl, body, { headers: headers_1.contentHeadersUrlEncoded })
            .subscribe(function (response) {
            console.log(response);
            if (response.json().result == "USER_NOT_FOUND") {
                alert(response.json().result);
            }
            else {
                _this.router.navigate(["/homePage"]);
            }
        }, function (error) {
            alert(error.text());
            console.log(error.text());
        });
    };
    LoginPage = __decorate([
        core_1.Component({
            selector: 'login-tag',
            templateUrl: 'app/authentication/login/login.component.html',
            directives: [router_1.ROUTER_DIRECTIVES]
        }), 
        __metadata('design:paramtypes', [router_1.Router, http_1.Http])
    ], LoginPage);
    return LoginPage;
}());
exports.LoginPage = LoginPage;
//# sourceMappingURL=login.component.js.map