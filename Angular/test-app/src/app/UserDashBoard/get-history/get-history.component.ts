import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../../admin-service.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-get-history',
  templateUrl: './get-history.component.html',
  styleUrls: ['./get-history.component.css']
})
export class GetHistoryComponent implements OnInit {
  HistoryList: any;
  FilteredList :any;
  constructor(private adminservice: AdminServiceService, private http:HttpClient) { }

  ngOnInit() {
    this.adminservice.currentdata.subscribe(HistoryList => this.HistoryList = HistoryList);
  }
  reset(){
    this.FilteredList = null;
  }
  filter(f)
  {
    // this.HistoryList = null;
    this.adminservice.getFilteredList(f).subscribe((res) =>{ 
        //console.log(res);
        this.FilteredList=res;
        console.log(this.FilteredList);
      }
    )
  } 

}
