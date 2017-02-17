package com.centric.centricexpress.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.centric.centricexpress.models.EventAttendant;

public interface EventAttendantRepository extends MongoRepository<EventAttendant, Long> {

}
