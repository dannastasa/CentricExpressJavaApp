package com.centric.centricexpress.repositories;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.centric.centricexpress.models.EventDay;

public interface EventDayRepository extends MongoRepository<EventDay, Long> {
    EventDay findById(Long id);

    EventDay findByDay(LocalDate date);
}
