import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {AccountComponent} from './account.component';
import {EditComponent} from "./edit.component";

const routes: Routes = [
  {
    path: '',
    component: AccountComponent,
    data: {
      title: 'Account'
    }
  },
  {
    path: 'accountEdit',
    component: EditComponent,
    data: {
      title: 'AccountEdit'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule {

}
