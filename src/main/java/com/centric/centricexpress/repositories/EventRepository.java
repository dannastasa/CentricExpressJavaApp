package com.centric.centricexpress.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.centric.centricexpress.models.Event;

public interface EventRepository extends MongoRepository<Event, Long> {

}
