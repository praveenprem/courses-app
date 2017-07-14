package org.app;

import org.app.models.Customer;
import org.app.models.Topic;
import org.app.services.CustomerService;
import org.app.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author:  andreicovaciu;
 * Date:    18-Jan-17.
 * <p>
 * HAPPY CODING!
 */
@SpringBootApplication
public class Application implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    private CustomerService customerService;
    @Autowired
    private TopicService topicService;

    @Override
    public void run(String... strings) throws Exception {
        /* Insert some dummy users */
        customerService.save(new Customer("dummy@dummy.com", "dummy1234"));
        /* Insert some dummy topics */
        topicService.addTopic(new Topic("Spring Framework", "Welcome to the most popular Java framework!"));
        topicService.addTopic(new Topic("Angular JS", "Welcome to Angular JS!"));
        topicService.addTopic(new Topic("Angular 2", "Welcome to Angular 2!"));
    }

}
