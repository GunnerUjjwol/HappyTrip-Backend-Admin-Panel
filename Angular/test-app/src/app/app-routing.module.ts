import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { GetHistoryComponent } from './UserDashBoard/get-history/get-history.component';
import { AddPackageComponent } from './UserDashBoard/add-package/add-package.component';
import { UserQueriesComponent } from './UserDashBoard/user-queries/user-queries.component';
import { ShowPackagesComponent } from './UserDashBoard/show-packages/show-packages.component';
import { AdminBodyComponent } from './UserDashBoard/admin-body/admin-body.component';

const routes: Routes = [
  { path: 'recentBookings', component: GetHistoryComponent },
  { path: 'addPackage', component: AddPackageComponent },
  { path: 'UserQueries', component: UserQueriesComponent },
  { path: 'showPackages', component: ShowPackagesComponent },
  { path: 'logout', redirectTo: '', pathMatch: 'full' },
  { path: '', component: AdminBodyComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
