package com.centric.centricexpress.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.centric.centricexpress.models.EventAttendant;

@Repository
public interface EventAttendantRepository extends MongoRepository<EventAttendant, Long> {

}
