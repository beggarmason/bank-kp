import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

// Import Containers
import {DefaultLayoutComponent} from './containers';

import {P404Component} from './views/error/404.component';
import {P500Component} from './views/error/500.component';
import {AccountEditComponent} from "./views/account/edit.component";
import {AccountAddComponent} from "./views/account/add.component";
import {AmountEditComponent} from "./views/amount/edit.component";
import {AmountAddComponent} from "./views/amount/add.component";
import {BankEditComponent} from "./views/bank/edit.component";
import {BankAddComponent} from "./views/bank/add.component";
import {BonusEditComponent} from "./views/bonus/edit.component";
import {BonusAddComponent} from "./views/bonus/add.component";
import {CityEditComponent} from "./views/city/edit.component";
import {CityAddComponent} from "./views/city/add.component";
import {DepositEditComponent} from "./views/deposit/edit.component";
import {DepositAddComponent} from "./views/deposit/add.component";
import {PlanEditComponent} from "./views/plan/edit.component";
import {PlanAddComponent} from "./views/plan/add.component";
import {RestrictionEditComponent} from "./views/restriction/edit.component";
import {RestrictionAddComponent} from "./views/restriction/add.component";
import {TypeEditComponent} from "./views/type/edit.component";
import {TypeAddComponent} from "./views/type/add.component";

interface dataRecord {
  id: number;
  active: boolean;
  created: Date;
  restriction: [];
  person: any;
}

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'account',
    pathMatch: 'full',
  },
  {
    path: 'accountEdit/:id',
    component: AccountEditComponent
  },
  {
    path: 'account/add',
    component: AccountAddComponent
  },
  {
    path: 'amount',
    redirectTo: 'amount',
  },
  {
    path: 'amountEdit/:id',
    component: AmountEditComponent
  },
  {
    path: 'amount/add',
    component: AmountAddComponent
  },
  {
    path: 'bank',
    redirectTo: 'bank',
  },
  {
    path: 'bankEdit/:id',
    component: BankEditComponent
  },
  {
    path: 'bank/add',
    component: BankAddComponent
  },
  {
    path: 'bonus',
    redirectTo: 'bonus',
  },
  {
    path: 'bonusEdit/:id',
    component: BonusEditComponent
  },
  {
    path: 'bonus/add',
    component: BonusAddComponent
  },
  {
    path: 'city',
    redirectTo: 'city',
  },
  {
    path: 'cityEdit/:id',
    component: CityEditComponent
  },
  {
    path: 'city/add',
    component: CityAddComponent
  },
  {
    path: 'deposit',
    redirectTo: 'deposit',
  },
  {
    path: 'depositEdit/:id',
    component: DepositEditComponent
  },
  {
    path: 'deposit/add',
    component: DepositAddComponent
  },
  {
    path: 'plan',
    redirectTo: 'plan',
  },
  {
    path: 'planEdit/:id',
    component: PlanEditComponent
  },
  {
    path: 'plan/add',
    component: PlanAddComponent
  },
  {
    path: 'restriction',
    redirectTo: 'restriction',
  },
  {
    path: 'restrictionEdit/:id',
    component: RestrictionEditComponent
  },
  {
    path: 'restriction/add',
    component: RestrictionAddComponent
  },
  {
    path: 'type',
    redirectTo: 'type',
  },
  {
    path: 'typeEdit/:id',
    component: TypeEditComponent
  },
  {
    path: 'type/add',
    component: TypeAddComponent
  },
  {
    path: '404',
    component: P404Component,
    data: {
      title: 'Page 404'
    }
  },
  {
    path: '500',
    component: P500Component,
    data: {
      title: 'Page 500'
    }
  },
  {
    path: '',
    component: DefaultLayoutComponent,
    data: {
      title: 'Home'
    },
    children: [
      {
        path: 'account',
        loadChildren: () => import('./views/account/account.module').then(m => m.AccountModule)
      },
      {
        path: 'amount',
        loadChildren: () => import('./views/amount/amount.module').then(m => m.AmountModule)
      },
      {
        path: 'bank',
        loadChildren: () => import('./views/bank/bank.module').then(m => m.BankModule)
      },
      {
        path: 'bonus',
        loadChildren: () => import('./views/bonus/bonus.module').then(m => m.BonusModule)
      },
      {
        path: 'city',
        loadChildren: () => import('./views/city/city.module').then(m => m.CityModule)
      },
      {
        path: 'deposit',
        loadChildren: () => import('./views/deposit/deposit.module').then(m => m.DepositModule)
      },
      {
        path: 'plan',
        loadChildren: () => import('./views/plan/plan.module').then(m => m.PlanModule)
      },
      {
        path: 'restriction',
        loadChildren: () => import('./views/restriction/restriction.module').then(m => m.RestrictionModule)
      },
      {
        path: 'type',
        loadChildren: () => import('./views/type/type.module').then(m => m.TypeModule)
      },
      {
        path: 'icons',
        loadChildren: () => import('./views/icons/icons.module').then(m => m.IconsModule)
      }
    ]
  },
  { path: '**', component: P404Component }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
