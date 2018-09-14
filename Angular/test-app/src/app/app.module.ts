import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { AppComponent } from './app.component';
import{FormsModule} from '@angular/forms';
import { AppRoutingModule } from './/app-routing.module';
import { NavbarAdminComponent } from './UserDashBoard/navbar-admin/navbar-admin.component';
import { GetHistoryComponent } from './UserDashBoard/get-history/get-history.component';
import { AddPackageComponent } from './UserDashBoard/add-package/add-package.component';
import { LogoutComponent } from './UserDashBoard/logout/logout.component';
import { UserQueriesComponent } from './UserDashBoard/user-queries/user-queries.component';
import { ShowPackagesComponent } from './UserDashBoard/show-packages/show-packages.component';
import { AdminBodyComponent } from './UserDashBoard/admin-body/admin-body.component';
import { AppHttpInterceptor } from './app-http-interceptor';



@NgModule({
  declarations: [
    AppComponent,    
    NavbarAdminComponent,
    GetHistoryComponent,
    AddPackageComponent,
    LogoutComponent,
    UserQueriesComponent,
    ShowPackagesComponent,
    AdminBodyComponent,
    AppHttpInterceptor
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AppHttpInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
