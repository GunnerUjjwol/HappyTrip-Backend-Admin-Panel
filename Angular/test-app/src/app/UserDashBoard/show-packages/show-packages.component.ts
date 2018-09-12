import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../../admin-service.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';




@Component({
  selector: 'app-show-packages',
  templateUrl: './show-packages.component.html',
  styleUrls: ['./show-packages.component.css']
})

export class ShowPackagesComponent implements OnInit {

  UserPackage: any;
  check:boolean;

  deletePackage(Formpackage) {
    this.check=(confirm("Are you sure you want to delete the package?"));
    if(this.check===true){
    this.adminservice.deletePackage(Formpackage).subscribe(() => {
      this.UserPackage.splice(this.UserPackage.indexOf(Formpackage.id), 1);
    });
  }
  }

  updatePackage(packageUpdate: any) {
    this.adminservice.changelabel('Update');
    this.adminservice.changeUpdate(packageUpdate);
  }
  constructor(private adminservice: AdminServiceService, private http: HttpClient) { }
  ngOnInit() {
    this.adminservice.currentUserpackages.subscribe(UserPackage => this.UserPackage = UserPackage)
  }

}
