package org.app.services;

import org.app.models.Course;
import org.app.models.Topic;
import org.app.repositories.CourseRepository;
import org.app.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:  andreicovaciu;
 * Date:    18-Jan-17.
 *
 * HAPPY CODING!
 */
@Service
public class CourseService {

    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public TopicRepository topicRepository;

    public List<Course> getAllCourses(String id) {
        return courseRepository.findByTopicId(id);
    }

    public Course getCourse(String id) {
        return courseRepository.findOne(id);
    }

    public void addCourse(String topicId, Course c) {
        courseRepository.save(c);
    }

    public void updateCourse(String topicId, Course c) {
        c.setTopic(topicRepository.findOne(topicId));
        courseRepository.save(c);
    }

    public void deleteCourse(String id) {
        courseRepository.delete(id);
    }

}
