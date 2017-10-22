import {Component, Input} from '@angular/core';
import {Topic} from "../topic";
import {TopicService} from "../topic.service";

@Component({
  selector: 'topic-detail',
  templateUrl: './topic-detail.component.html',
  styleUrls: ['./topic-detail.component.css']
})
export class TopicDetailComponent {

  @Input() topic: Topic;

  constructor(private topicService: TopicService){}

  saveTopicName(topic: Topic) : void {
    console.log(topic);
    this.topicService.putTopic(topic);
  }

  deleteTopic(topic: Topic) : void {
    this.topicService.deleteTopic(topic);
    location.reload();
  }
}
