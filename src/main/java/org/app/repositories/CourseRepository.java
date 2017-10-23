package org.app.repositories;

import org.app.models.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findByTopicId(long topicId);

    Course findByName(String name);

    void deleteByName(String name);

    void deleteById(long id);
}
