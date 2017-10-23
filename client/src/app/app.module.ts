import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule} from "@angular/router"
import {HttpModule} from '@angular/http';

import {TopicsComponent} from './topics/topics.component';
import {TopicDetailComponent} from './topic-detail/topic-detail.component';
import {AppComponent} from "./app.component";
import {TopicService} from "./service/topic.service";
import { AddTopicComponent } from './add-topic/add-topic.component';
import { CoursesComponent } from './courses/courses.component';


@NgModule({
  declarations: [
    AppComponent,
    TopicDetailComponent,
    TopicsComponent,
    AddTopicComponent,
    CoursesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      {
        path: 'topics',
        component: TopicsComponent
      },
      {
        path: 'addTopic',
        component: AddTopicComponent
      },
      {
        path: 'topicDetail',
        component: TopicDetailComponent
      }
    ])
  ],
  providers: [TopicService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
