import { bootstrap } from '@angular/platform-browser-dynamic';
import { provide } from '@angular/core';
import { ROUTER_PROVIDERS } from '@angular/router';
import { LocationStrategy, Location, HashLocationStrategy } from '@angular/common';
import { HTTP_PROVIDERS } from '@angular/http';

import { AppComponent } from './main-component/app.component';

bootstrap(AppComponent, [
 ROUTER_PROVIDERS,
 HTTP_PROVIDERS,
 provide(LocationStrategy, {useClass: HashLocationStrategy}),
 provide(Window, {useValue: window})
]);


