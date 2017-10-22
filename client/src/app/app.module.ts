import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule} from "@angular/router"
import {HttpModule} from '@angular/http';

import {TopicsComponent} from './topics.component';
import {TopicDetailComponent} from './topic-detail/topic-detail.component';
import {AppComponent} from "./app.component";
import {TopicService} from "./topic.service";
import { AddTopicComponent } from './add-topic/add-topic.component';


@NgModule({
  declarations: [
    AppComponent,
    TopicDetailComponent,
    TopicsComponent,
    AddTopicComponent
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
      }
    ])
  ],
  providers: [TopicService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
