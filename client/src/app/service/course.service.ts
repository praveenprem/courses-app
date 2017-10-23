import { Injectable } from '@angular/core';
import {Headers, Http, RequestOptions} from "@angular/http";
import 'rxjs/add/operator/toPromise';

@Injectable()
export class CourseService {

  constructor(private http: Http) { }

}
