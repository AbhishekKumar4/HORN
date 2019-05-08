import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'user'
  password = ''
  errorMessage = 'Invalid Credentials'
  invalidLogin = false;
  //Router
  //Dependency Injection
  constructor(private router : Router, private hardcodedAuthenticationService: HardcodedAuthenticationService) { }
  //IN typescript this variable will be available as member variable, in case of constructor args
  ngOnInit() {
  }

  onSubmit() {
    console.log('I am running')

  if(this.hardcodedAuthenticationService.authenticate(this.username, this.password)) {
    //I need to validate it with credentials api, so i need router
    this.router.navigate(['welcome'])
    this.invalidLogin = false
  }
  else {
    this.invalidLogin = true
  }

  }
}
