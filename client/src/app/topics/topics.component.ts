import {Component, OnInit} from '@angular/core';
import {Topic} from "../model/topic";
import {TopicService} from "../service/topic.service";

@Component({
  selector: 'topics',
  templateUrl: './topics.component.html',
  styleUrls: ['./topics.component.css'],
  providers: [TopicService]
})
export class TopicsComponent implements OnInit {
  ngOnInit(): void {
    this.getTopics();
  }

  topics: Topic[];

  constructor(private topicService: TopicService) {
  }

  getTopics(): void {
    this.topicService.getTopics().then(topics => this.topics = topics);
  }

  onSelect(topic: Topic): void {
    console.log(topic.id + " " + topic.name + " " + topic.description + " " + topic.available);
    // this.selectedTopic = selectedTopic;
    this.topicService.setSelectedTopic(topic);
    this.topicService.setTopics(this.topics);
  }
}
