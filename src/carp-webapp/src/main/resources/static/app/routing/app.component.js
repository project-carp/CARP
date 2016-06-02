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
var login_component_1 = require('../login/login.component');
var home_component_1 = require('../home/home.component');
var router_deprecated_1 = require('@angular/router-deprecated');
var http_1 = require('@angular/http');
var AppComponent = (function () {
    function AppComponent() {
        this.title = 'Main Page CarPooling';
    }
    AppComponent = __decorate([
        core_1.Component({
            selector: 'main-tag',
            templateUrl: 'app/routing/main.component.html',
            directives: [router_deprecated_1.ROUTER_DIRECTIVES],
            providers: [router_deprecated_1.ROUTER_PROVIDERS, http_1.HTTP_PROVIDERS]
        }),
        router_deprecated_1.RouteConfig([
            {
                path: '/loginPage',
                name: 'LoginPage',
                component: login_component_1.LoginPage,
            },
            {
                path: '/homePage',
                name: 'HomePage',
                component: home_component_1.HomePage,
            },
        ]), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map