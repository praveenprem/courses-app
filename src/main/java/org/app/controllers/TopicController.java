package org.app.controllers;

import org.app.models.Topic;
import org.app.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author:  andreicovaciu;
 * Date:    18-Jan-17.
 *
 * HAPPY CODING!
 */
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/api/topics", produces = "application/json")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/api/topics/{id}", produces = "application/json")
    public Topic getTopic(@PathVariable long id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(value = "/api/topics", method = RequestMethod.POST, consumes = "application/json")
    public void addTopic(@RequestBody Topic t) {
        topicService.addTopic(t);
    }

    @RequestMapping(value = "/api/topics/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public void updateTopic(@PathVariable String id, @RequestBody Topic t) {
        topicService.updateTopic(t);
    }

    @RequestMapping(value = "/api/topics/{id}", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteTopic(@PathVariable long id) {
        topicService.deleteTopic(id);
    }
}
