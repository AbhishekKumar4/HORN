import { Component, OnInit } from '@angular/core';
import { DummyService } from 'src/app/service/dummy.service';
import { Account } from '../model/Account';


export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  tiles: Tile[] = [
    {text: 'One', cols: 3, rows: 1, color: 'lightblue'},
    {text: 'Two', cols: 1, rows: 2, color: 'lightgreen'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];

  IMAGES = [
    `https://material.angular.io/assets/img/examples/shiba2.jpg`,
    `https://material.angular.io/assets/img/examples/shiba2.jpg`
     ];

  displayedColumns: string[] = ['images'];
  photos :Array<Account>;
  constructor(private service: DummyService) { }

  ngOnInit() {
    this.photos = this.service.findAllPhotos();
    console.log(this.service.findAllPhotos());
  }

}
