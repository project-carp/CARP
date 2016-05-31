import { Component } from '@angular/core'
import { LoginPage } from '../login/login.component'
import { HomePage } from '../home/home.component'
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from '@angular/router-deprecated';
import { Http, HTTP_PROVIDERS } from '@angular/http';

@Component({
	selector: 'main-tag',
	templateUrl: 'app/routing/main.component.html',
	directives: [ROUTER_DIRECTIVES],
	providers: [ROUTER_PROVIDERS, HTTP_PROVIDERS]
})

@RouteConfig([
	{
		path: '/loginPage',
		name: 'LoginPage',
		component: LoginPage,
	},
	{
		path: '/homePage',
		name: 'HomePage',
		component: HomePage,
	},
])

export class AppComponent {
	title = 'Main Page CarPooling';
}