import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AdminServiceService } from '../../admin-service.service';

@Component({
 
  templateUrl: './add-package.component.html',
  styleUrls: ['./add-package.component.css']
})
export class AddPackageComponent implements OnInit {
  Create_Update="Create";
  model : any;
  hide:boolean= false;
  
  createPackage(packageForm){
    this.hide=true;
    if(this.Create_Update === "Create")
    {
          this.adminservice.addPackage(packageForm).subscribe((data)=>{
        });
    }
    else if(this.Create_Update === "Update")
    {
         this.adminservice.updatePackage(packageForm).subscribe((data)=>{
      });
    }
  }
  
  constructor(private http : HttpClient,private adminservice:AdminServiceService) { }

  ngOnInit() {
    this.adminservice.currentpackageLabel.subscribe(packageName => this.Create_Update = packageName);
    this.adminservice.currentupdateData.subscribe(modelUpdate =>this.model = modelUpdate);
    this.adminservice.currentSuccess.subscribe(changeSuccess =>this.hide = changeSuccess);
  }

}
