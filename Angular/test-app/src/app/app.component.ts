import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { TokenServiceService } from './token-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Admin Panel- Happy Trip';
  response :any;
  loginToken: string = null;

  constructor(private http : HttpClient, private router:Router, private tokenService: TokenServiceService){
  }
  getJson(){
    let obs = this.http.get("http://localhost:8080/Customers/all");
    obs.subscribe((response)=>{
      console.log(response);
      this.response = response;
    });
  }
  ngOnInit():void{
    this.tokenService.tokenEmitter.subscribe(token => {
      this.loginToken = token;
    });
    this.loginToken = sessionStorage.getItem('token');
    if (this.loginToken == null || this.loginToken === '') {
      this.router.navigate(['/login']);
    }
   
   
  }
}
