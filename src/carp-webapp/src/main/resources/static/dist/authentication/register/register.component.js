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
var user_1 = require('../user');
var register_service_1 = require('./register.service');
var RegisterPage = (function () {
    function RegisterPage(router, registerService) {
        this.router = router;
        this.registerService = registerService;
    }
    RegisterPage.prototype.addNerUser = function (email, password) {
        var user = new user_1.User(email, password);
        this.registerUser(user);
    };
    RegisterPage.prototype.registerUser = function (user) {
        var _this = this;
        this.registerService
            .registerNewUser(user)
            .then(function (user) {
            _this.goHomePage();
        })
            .catch(function (error) { return _this.error = error; });
    };
    RegisterPage.prototype.goHomePage = function () {
        this.router.navigate(["/homePage"]);
    };
    RegisterPage = __decorate([
        core_1.Component({
            selector: 'register-tag',
            templateUrl: 'app/authentication/register/register.component.html',
            directives: [router_1.ROUTER_DIRECTIVES],
            providers: [register_service_1.RegisterService]
        }), 
        __metadata('design:paramtypes', [router_1.Router, register_service_1.RegisterService])
    ], RegisterPage);
    return RegisterPage;
}());
exports.RegisterPage = RegisterPage;
