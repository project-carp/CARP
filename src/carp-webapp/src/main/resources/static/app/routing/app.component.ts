import { Component } from '@angular/core'
import { LoginPage } from '../login/login.component'
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from '@angular/router-deprecated';

@Component({
	selector: 'main-tag',
	templateUrl: 'app/routing/main.component.html',
	directives: [ROUTER_DIRECTIVES],
	providers: [ROUTER_PROVIDERS]
})

@RouteConfig([
	{
		path: '/loginPage',
		name: 'LoginPage',
		component: LoginPage,
	},
])

export class AppComponent {
	title = 'CarPooling';
}