import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { filter, tap, map} from 'rxjs/operators';
import { Account } from 'src/app/model/Account';


export const ACCOUNTS: Account[] = [
    {
          id: 1, url: 'https://material.angular.io/assets/img/examples/shiba2.jpg'
    },
    {
          id: 2, url: 'https://material.angular.io/assets/img/examples/shiba2.jpg'
    },
    {
          id: 3, url: 'https://material.angular.io/assets/img/examples/shiba2.jpg'
    },
    {
        id: 4, url: 'https://material.angular.io/assets/img/examples/shiba2.jpg'
  },
  {
        id: 5, url: 'https://material.angular.io/assets/img/examples/shiba2.jpg'
  },
  {
        id: 6, url: 'https://material.angular.io/assets/img/examples/shiba2.jpg'
  }
];


@Injectable()
export class DummyService {

    
    constructor(private http: HttpClient) { }
    //photos: Array<PhotosModel>;
    public findAllPhotos(): Array<Account> {
        //const url = 'http://localhost:3000/posts';
        //var test =  this.http.get(url).pipe(map((response: any) => response.json()));
        return ACCOUNTS;
    }
}