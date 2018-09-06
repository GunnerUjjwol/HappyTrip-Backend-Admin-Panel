import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../../admin-service.service';

@Component({
  selector: 'app-get-history',
  templateUrl: './get-history.component.html',
  styleUrls: ['./get-history.component.css']
})
export class GetHistoryComponent implements OnInit {
  HistoryList : any;
 
  constructor(private adminservice:AdminServiceService) { }

  ngOnInit() {
    this.adminservice.currentdata.subscribe(HistoryList => this.HistoryList = HistoryList)
   
  }

}
