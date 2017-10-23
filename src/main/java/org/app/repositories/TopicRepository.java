package org.app.repositories;

import org.app.models.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Long> {
    Topic findByName(String name);

    void deleteByName(String name);
}
