package com.centric.centricexpress.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.centric.centricexpress.models.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, Long> {

}
