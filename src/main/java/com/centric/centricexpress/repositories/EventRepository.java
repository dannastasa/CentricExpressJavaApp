package com.centric.centricexpress.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.centric.centricexpress.models.Event;

public interface EventRepository extends MongoRepository<Event, Long> {
    Event findById(Long id);

    Event findEventByName(String name);

    List<Event> findEventsByLocation(String location);
}
