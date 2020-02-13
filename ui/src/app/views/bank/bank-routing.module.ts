import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {BankComponent} from './bank.component';

const routes: Routes = [
  {
    path: '',
    component: BankComponent,
    data: {
      title: 'Банк'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule {

}
