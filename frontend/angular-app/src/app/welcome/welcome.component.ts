import { Component, OnInit } from '@angular/core';
import { DummyService } from 'src/app/service/dummy.service'

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  profile :any;
  constructor(private service: DummyService) { }

  ngOnInit() {
    console.log(this.service.findAllDepartment().subscribe(profile => this.profile = profile));
  }

}
