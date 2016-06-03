import { bootstrap } from '@angular/platform-browser-dynamic';
import { provide } from '@angular/core';
import { ROUTER_PROVIDERS } from '@angular/router';
import { LocationStrategy, Location, HashLocationStrategy } from '@angular/common';

import { AppComponent } from './main-component/app.component';

bootstrap(AppComponent, [
 ROUTER_PROVIDERS,
 provide(LocationStrategy, {useClass: HashLocationStrategy})
]);


