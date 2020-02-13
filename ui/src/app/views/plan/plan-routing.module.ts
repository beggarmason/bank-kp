import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {PlanComponent} from './plan.component';

const routes: Routes = [
  {
    path: '',
    component: PlanComponent,
    data: {
      title: 'План'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule {

}
