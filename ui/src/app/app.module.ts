import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {LocationStrategy, HashLocationStrategy, DatePipe} from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';

import { AppComponent } from './app.component';

// Import containers
import { DefaultLayoutComponent } from './containers';

import { P404Component } from './views/error/404.component';
import { P500Component } from './views/error/500.component';

const APP_CONTAINERS = [
  DefaultLayoutComponent
];

import {
  AppAsideModule,
  AppBreadcrumbModule,
  AppHeaderModule,
  AppFooterModule,
  AppSidebarModule,
} from '@coreui/angular';

// Import routing module
import { AppRoutingModule } from './app.routing';

// Import 3rd party components
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { ChartsModule } from 'ng2-charts';
import { HttpClientModule } from '@angular/common/http';


import { MatTableModule } from "@angular/material/table";
import {FormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {AccountEditComponent} from "./views/account/edit.component";
import {AccountAddComponent} from "./views/account/add.component";
import {AmountAddComponent} from "./views/amount/add.component";
import {AmountEditComponent} from "./views/amount/edit.component";
import {BankAddComponent} from "./views/bank/add.component";
import {BankEditComponent} from "./views/bank/edit.component";
import {BonusEditComponent} from "./views/bonus/edit.component";
import {BonusAddComponent} from "./views/bonus/add.component";
import {CityAddComponent} from "./views/city/add.component";
import {CityEditComponent} from "./views/city/edit.component";
import {DepositAddComponent} from "./views/deposit/add.component";
import {DepositEditComponent} from "./views/deposit/edit.component";
import {PlanAddComponent} from "./views/plan/add.component";
import {PlanEditComponent} from "./views/plan/edit.component";
import {RestrictionAddComponent} from "./views/restriction/add.component";
import {RestrictionEditComponent} from "./views/restriction/edit.component";
import {TypeEditComponent} from "./views/type/edit.component";
import {TypeAddComponent} from "./views/type/add.component";

@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatTableModule,
    AppAsideModule,
    AppBreadcrumbModule.forRoot(),
    AppFooterModule,
    HttpClientModule,
    AppHeaderModule,
    AppSidebarModule,
    PerfectScrollbarModule,
    BsDropdownModule.forRoot(),
    TabsModule.forRoot(),
    ChartsModule,
    FormsModule,
    MatFormFieldModule
  ],
  declarations: [
    AppComponent,
    AccountEditComponent,
    AccountAddComponent,
    AmountAddComponent,
    AmountEditComponent,
    BankAddComponent,
    BankEditComponent,
    BonusAddComponent,
    BonusEditComponent,
    CityAddComponent,
    CityEditComponent,
    DepositAddComponent,
    DepositEditComponent,
    PlanAddComponent,
    PlanEditComponent,
    RestrictionAddComponent,
    RestrictionEditComponent,
    TypeEditComponent,
    TypeAddComponent,
    ...APP_CONTAINERS,
    P404Component,
    P500Component
  ],
  providers: [{
    provide: LocationStrategy,
    useClass: HashLocationStrategy
  },{
    provide: DatePipe
  }],
  exports: [
    AppComponent,
    AccountAddComponent, AccountEditComponent,
    AmountAddComponent, AmountEditComponent,
    BankAddComponent, BankEditComponent,
    BonusAddComponent, BonusEditComponent,
    CityAddComponent, CityEditComponent,
    DepositAddComponent, DepositEditComponent,
    PlanAddComponent, PlanEditComponent,
    RestrictionAddComponent, RestrictionEditComponent,
    TypeAddComponent, TypeEditComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
