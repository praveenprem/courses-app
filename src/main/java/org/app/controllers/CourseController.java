package org.app.controllers;

import org.app.models.Course;
import org.app.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/api/topics/{topicId}/courses")
    public List<Course> getAllCoursesByTopic(@PathVariable long topicId) {
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/api/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable long courseId) {
        return courseService.getCourse(courseId);
    }

    @RequestMapping(value = "/api/topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@PathVariable long topicId, @RequestBody Course c) {
        courseService.addCourse(c);
    }

    @RequestMapping(value = "/api/topics/{topicId}/courses", method = RequestMethod.PUT)
    public void updateCourse(@PathVariable long topicId, @RequestBody Course c) {
        courseService.updateCourse(topicId, c);
    }

    @RequestMapping(value = "/api/topics/{topicId}/courses/{courseId}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable long topicId, @PathVariable long courseId) {
        courseService.deleteCourse(courseId);
    }

    @GetMapping("/api/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

}
