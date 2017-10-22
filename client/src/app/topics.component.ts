import {Component, OnInit} from '@angular/core';
import {Topic} from "./topic";
import {TopicService} from "./topic.service";

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

  selectedTopic: Topic;
  topics: Topic[];

  constructor(private topicService: TopicService) {
  }

  getTopics(): void {
    this.topicService.getTopics().then(topics => this.topics = topics);
  }

  onSelect(topic: Topic): void {
    this.selectedTopic = topic;
  }
  refreshTopics() {
    location.reload();
  }
}
