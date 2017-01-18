package org.app.repositories;

import org.app.models.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Author:  andreicovaciu;
 * Date:    18-Jan-17.
 *
 * HAPPY CODING!
 */
public interface CourseRepository extends CrudRepository<Course, String> {
    public List<Course> findByTopicId(String topicId);

    public Course findByName(String name);

}
