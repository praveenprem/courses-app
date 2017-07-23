import {Component, Input} from '@angular/core';
import {Topic} from "./topic";

@Component({
  selector: 'topic-detail',
  templateUrl: './topic-detail.component.html',
  styleUrls: ['./topic-detail.component.css']
})
export class TopicDetailComponent {

  @Input() topic: Topic;

  saveTopicName(topic: Topic) : void {
    console.log(topic);
  }
}
