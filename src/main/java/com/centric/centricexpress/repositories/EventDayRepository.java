package com.centric.centricexpress.repositories;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.centric.centricexpress.models.EventDay;

@Repository
<<<<<<< Updated upstream
public interface EventDayRepository extends MongoRepository<EventDay, Long> {
=======
public interface EventDayRepository extends MongoRepository<EventDay, String> {
    EventDay findById(String id);
>>>>>>> Stashed changes

    EventDay findByDate(LocalDate date);
}
