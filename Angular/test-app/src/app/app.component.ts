import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Admin Panel- Happy Trip';
  response :any;
  constructor(private http : HttpClient){
  }
  getJson(){
    let obs = this.http.get("http://localhost:8080/Customers/all");
    obs.subscribe((response)=>{
      console.log(response);
      this.response = response;
    });
  }
  ngOnInit(){
   
  }
}
