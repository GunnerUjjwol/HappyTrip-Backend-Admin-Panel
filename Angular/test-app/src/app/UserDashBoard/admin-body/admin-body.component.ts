import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenServiceService } from '../../token-service.service';

@Component({
  selector: 'app-admin-body',
  templateUrl: './admin-body.component.html',
  styleUrls: ['./admin-body.component.css']
})
export class AdminBodyComponent implements OnInit {

  username: string;
  password: string;

  constructor(private router: Router, private tokenService: TokenServiceService) { }

  ngOnInit() {
  }

  login(f): void {
    const loginToken = btoa(`${this.username}:${this.password}`);
    sessionStorage.setItem('token', loginToken);
    this.router.navigate(['/addPackage']);
    this.tokenService.tokenEmitter.next(loginToken);
  }

}
