import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

// Import Containers
import {DefaultLayoutComponent} from './containers';

import {P404Component} from './views/error/404.component';
import {P500Component} from './views/error/500.component';
import {EditComponent} from "./views/account/edit.component";
import {analyticsPackageSafelist} from "@angular/cli/models/analytics";
import {AddComponent} from "./views/account/add.component";

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
    component: EditComponent
  },
  {
    path: 'account/add',
    component: AddComponent
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
