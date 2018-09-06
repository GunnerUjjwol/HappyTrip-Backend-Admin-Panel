import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../../admin-service.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-navbar-admin',
  templateUrl: './navbar-admin.component.html',
  styleUrls: ['./navbar-admin.component.css']
})
export class NavbarAdminComponent implements OnInit {
  
  changePackageName(){
    this.adminservice.changeSuccess(false);
    this.adminservice.changelabel('Create');
    this.adminservice.changeUpdate('');
  }
  getBookingHistory(){
    this.adminservice.getBookingHistory().subscribe((HistoryList)=>{
      this.adminservice.changeHistory(HistoryList);
    });
  }
  getUserHistory(){
     this.adminservice.getUserHistory().subscribe((UserQuery)=>{
      this.adminservice.changeQuery(UserQuery);
    })
  }
  getPackges(){
   this.adminservice.getPackage().subscribe((userPackage)=>{
      this.adminservice.changeSuccess(false);
      this.adminservice.changePackage(userPackage);
    })
  }

  constructor(private adminservice:AdminServiceService,private http:HttpClient) { }

  ngOnInit() {
    
  }

}
