import {Component, Input, OnInit} from '@angular/core';
import {TopicService} from "../topic.service";
import {Topic} from "../topic";

@Component({
  selector: 'add-topic',
  templateUrl: './add-topic.component.html',
  styleUrls: ['./add-topic.component.css']
})
export class AddTopicComponent implements OnInit {

  constructor(private topicService: TopicService) { }

  topic: Topic = new Topic();

  ngOnInit() {

  }

  addTopic(topic: Topic) {
    this.topic = topic;
    this.topicService.postTopic(this.topic);
    console.log(topic);
  }

}
