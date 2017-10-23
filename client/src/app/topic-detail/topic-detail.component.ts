import {Component, OnInit} from "@angular/core";
import {Topic} from "../model/topic";
import {TopicService} from "../service/topic.service";

@Component({
  selector: 'topic-detail',
  templateUrl: './topic-detail.component.html',
  styleUrls: ['./topic-detail.component.css']
})
export class TopicDetailComponent implements OnInit {

  selectedTopic: Topic;
  topics: Topic[];

  constructor(private topicService: TopicService){}

  ngOnInit(): void {
    //Subscribe to the service to get newest updates. Should update asynchronously
    this.topicService.getSelectedTopic().subscribe((topic: Topic) => {
      console.log(topic);
      this.selectedTopic = topic;
    });

    // Subscribe to topics to get newest changes from service. Should update asynchronously
    this.topicService.getLocalTopics().subscribe((topics: Topic[]) => {
      this.topics = topics;
      console.log(topics);
    });
    // console.log(this.topicService.selectedTopic);
  }

  saveTopicName(topic: Topic): void {
    console.log(topic);
    this.topicService.putTopic(topic);
  }

  deleteTopic(topic: Topic): void {
    this.topicService.deleteTopic(topic);
    if (this.topics == null) {
      console.log("topics is null" + this.topics);
      return;
    }
    this.topics = this.topics.filter(item => item !== topic);
    console.log(this.topics);
  }
}
