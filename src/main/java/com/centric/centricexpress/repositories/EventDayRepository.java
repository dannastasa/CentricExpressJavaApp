package com.centric.centricexpress.repositories;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.centric.centricexpress.models.EventDay;

@Repository
public interface EventDayRepository extends MongoRepository<EventDay, Long> {
    EventDay findById(Long id);

    EventDay findByDate(LocalDate date);
}
