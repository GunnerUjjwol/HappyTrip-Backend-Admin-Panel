import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../../admin-service.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-queries',
  templateUrl: './user-queries.component.html',
  styleUrls: ['./user-queries.component.css']
})
export class UserQueriesComponent implements OnInit {
  UserQueries: any;
  deleteQuery(userQuery) {
    this.adminservice.deleteQueries(userQuery).subscribe(() => {
      this.UserQueries.splice(this.UserQueries.indexOf(userQuery.messageId), 1);
    });
  }
  constructor(private adminservice: AdminServiceService, private http: HttpClient) { }

  ngOnInit() {
    this.adminservice.currentUserqueries.subscribe(UserQueries => this.UserQueries = UserQueries);
  }


}
