package com.centric.centricexpress.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.centric.centricexpress.models.Event;

@Repository
<<<<<<< Updated upstream
public interface EventRepository extends MongoRepository<Event, Long> {
=======
public interface EventRepository extends MongoRepository<Event, String> {
    Event findById(String id);

    Event findEventByName(String name);
>>>>>>> Stashed changes

    Event findEventByName(String name);

    List<Event> findEventsByLocation(String location);
}
