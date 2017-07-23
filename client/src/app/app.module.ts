import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule} from "@angular/router"

import {TopicsComponent} from './topics.component';
import {TopicDetailComponent} from './topic-detail.component';
import {AppComponent} from "./app.component";
import {TopicService} from "./topic.service";


@NgModule({
  declarations: [
    AppComponent,
    TopicDetailComponent,
    TopicsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot([
      {
        path: 'topics',
        component: TopicsComponent
      }
    ])
  ],
  providers: [TopicService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
