import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {AmountComponent} from './amount.component';

const routes: Routes = [
  {
    path: '',
    component: AmountComponent,
    data: {
      title: 'Счет'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule {

}
