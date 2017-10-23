package org.app.services;

import org.app.models.Course;
import org.app.repositories.CourseRepository;
import org.app.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.google.common.collect.Lists;

/**
 * Author:  andreicovaciu;
 * Date:    18-Jan-17.
 *
 * HAPPY CODING!
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TopicRepository topicRepository;

    public List<Course> getAllCourses(long id) {
        return courseRepository.findByTopicId(id);
    }

    public List<Course> getAllCourses() {
        return Lists.newArrayList(courseRepository.findAll());
    }

    public Course getCourse(long id) {
        return courseRepository.findOne(id);
    }

    public void addCourse(Course c) {
        courseRepository.save(c);
    }

    public void updateCourse(long topicId, Course c) {
        c.setTopic(topicRepository.findOne(topicId));
        courseRepository.save(c);
    }

    public void deleteCourse(long id) {
        courseRepository.delete(id);
    }

}
