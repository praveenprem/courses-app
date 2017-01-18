package org.app.controllers;

import org.app.models.Course;
import org.app.models.Topic;
import org.app.services.CourseService;
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
public class CourseController {

    @Autowired
    public CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return courseService.getCourse(courseId);
    }

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@PathVariable String topicId, @RequestBody Course c) {
        c.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(topicId, c);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.PUT)
    public void updateCourse(@PathVariable String topicId, @PathVariable String courseId, @RequestBody Course c) {
        c.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(topicId, c);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
    }

}
