import {Injectable} from "@angular/core";
import {Topic} from "./topic";
import {Headers, Http, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class TopicService {
  private headers = new Headers({'Content-Type': 'application/json'});
  result: Promise<Topic[]>;
  constructor(private http: Http) { }
  getTopics(): Promise<Topic[]> {
    this.result =  this.http.get("/api/topics")
      .toPromise()
      .then(response => response.json() as Topic[])
      .catch(this.handleError);
    console.log(this.result);
    return this.result;
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }


  putTopic(topic: Topic) : void {
    let options = new RequestOptions({ headers: this.headers });
    let endpoint = "/api/topics/" + topic.id;
    this.http.put(endpoint, JSON.stringify(topic), options)
      .toPromise()
      .then(() => topic)
      .catch(this.handleError);
  }

}
