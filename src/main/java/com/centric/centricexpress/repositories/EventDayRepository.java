package com.centric.centricexpress.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.centric.centricexpress.models.EventDay;

public interface EventDayRepository extends MongoRepository<EventDay, Long> {

}
