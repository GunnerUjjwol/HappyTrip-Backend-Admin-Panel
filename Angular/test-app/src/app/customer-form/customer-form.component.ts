import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {

  model: any = {};

  onSubmit(): void {
    let obs = this.httpclient.post("http://localhost:8080/Customers/add", JSON.stringify(this.model));
    obs.subscribe((response) => {
      console.log(response);
    });
  }


  constructor(private httpclient: HttpClient) { }

  ngOnInit() {
  }

}
