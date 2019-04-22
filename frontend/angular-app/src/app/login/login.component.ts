import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  //Router
  //Dependency Injection
  constructor(private router : Router) { }
  //IN typescript this variable will be available as member variable, in case of constructor args
  ngOnInit() {
  }

  onSubmit() {
    console.log('I am running')

    //I need to validate it with credentials api, so i need router
    this.router.navigate(['welcome'])

  }
}
