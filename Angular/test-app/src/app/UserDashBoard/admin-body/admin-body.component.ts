import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenServiceService } from '../../token-service.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-admin-body',
  templateUrl: './admin-body.component.html',
  styleUrls: ['./admin-body.component.css']
})
export class AdminBodyComponent implements OnInit {

  email: string;
  password: string;
  loginToken:string;
  constructor(private http:HttpClient,private router: Router, private tokenService: TokenServiceService) { }

  ngOnInit() {
  }
  
  login(f){
    this.loginToken=btoa(`${this.email}:${this.password}`);
    sessionStorage.setItem('token',this.loginToken);
    this.tokenService.tokenEmitter.next(this.loginToken);
    console.log(atob(this.loginToken));
    this.http.get("http://localhost:8090/Customers/admin/check").subscribe(
      ()=>{
        
        console.log(this.loginToken);
        
        this.router.navigate(['/welcome']);
      },
      ()=>{
        alert("Username or password invalid!!!");
        this.tokenService.tokenEmitter.next(null);
        sessionStorage.removeItem('token');
      },
      ()=>{

      });
   

  }
  // login(f): void {
    
  //   const loginToken = btoa(`${this.email}:${this.password}`);
   
  //   sessionStorage.setItem('token', loginToken);
  //   this.router.navigate(['/addPackage']);
  //   this.tokenService.tokenEmitter.next(loginToken);
  // }

}
