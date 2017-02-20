package com.centric.centricexpress.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.centric.centricexpress.models.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, Long> {
    Event findById(String id);

    Event findEventByName(String name);

    List<Event> findEventsByLocation(String location);
}
