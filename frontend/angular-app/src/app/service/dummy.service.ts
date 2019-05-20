import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable()
export class DummyService {
    constructor(private http: HttpClient) { }

    public findAllDepartment(): Observable<any> {
        const url = 'http://localhost:3000/posts';
        return this.http.get(url);

    }
}