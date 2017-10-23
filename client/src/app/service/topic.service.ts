import {Injectable} from "@angular/core";
import {Topic} from "../model/topic";
import {Headers, Http, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {Subject} from "rxjs/Subject";
import {Observable} from "rxjs/Observable";


@Injectable()
export class TopicService {

  constructor(private http: Http) {
  }
  
  // Two variable are now will keep last value given until the service not destroyed.
  selectedTopic: Subject<Topic> = new Subject();


  topics: Subject<Topic[]> = new Subject();

  // selected selectedTopic to share data between Topic and TopicDetail component
  setSelectedTopic(topic: Topic) {
    // This will set new value to the variable
    this.selectedTopic.next(topic);

  }

  setTopics(topics: Topic[]) {
    console.log("setting topics " + topics);
    // This will set new value to the variable
    this.topics.next(topics);

  }

  /**
   * This method will allow component to subscribe to the selectedTopic as if it was a service
   * @returns {Observable<Topic>}
   */
  getSelectedTopic(): Observable<Topic> {
    return this.selectedTopic.asObservable();
  }


  /**
   * This method will allow compinent to subscribe to the #topics array
   * @returns {Observable<Topic[]>}
   */
  getLocalTopics(): Observable<Topic[]> {
    return this.topics.asObservable();
  }
  private headers = new Headers({'Content-Type': 'application/json'});

  result: Promise<Topic[]>;

  getTopics(): Promise<Topic[]> {
    this.result = this.http.get("/api/topics")
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


  putTopic(topic: Topic): void {
    let options = new RequestOptions({headers: this.headers});
    let endpoint = "/api/topics/" + topic.id;
    this.http.put(endpoint, JSON.stringify(topic), options)
      .toPromise()
      .then(() => topic)
      .catch(this.handleError);
  }

  postTopic(topic: Topic): void {
    let options = new RequestOptions({headers: this.headers});
    let endpoint = "/api/topics/";
    this.http.post(endpoint, JSON.stringify(topic), options)
      .toPromise()
      .then(() => topic)
      .catch(this.handleError);
  }

  deleteTopic(topic: Topic): void {
    let options = new RequestOptions({headers: this.headers});
    let endpoint = "/api/topics/" + topic.id;
    this.http.delete(endpoint, options)
      .toPromise()
      .then(() => topic)
      .catch(this.handleError);
  }
}
