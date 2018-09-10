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

  constructor(private adminservice: AdminServiceService, private http:HttpClient) { }

  ngOnInit() {
    this.adminservice.currentdata.subscribe(HistoryList => this.HistoryList = HistoryList);


  }

  filter(f)
{
console.log(f.value.fromDate);
this.http.get("http://localhost:8090/Booking/filter/"+ f.value.fromDate+"/"+f.value.toDate)
.subscribe(
(res) =>{ 
  //console.log(res);
this.HistoryList=res;
console.log(this.HistoryList);}
)
} 

}
