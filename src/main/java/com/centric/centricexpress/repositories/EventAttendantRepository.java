package com.centric.centricexpress.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.centric.centricexpress.models.EventAttendant;

public interface EventAttendantRepository extends MongoRepository<EventAttendant, Long> {
    EventAttendant findById(Long id);

    List<EventAttendant> findByLastName(String lastName);

    List<EventAttendant> findByFirstName(String firstName);

    List<EventAttendant> findByFirstNameOrLastName(String firstName, String lastName);

    List<EventAttendant> findByFirstNameAndLastName(String firstName, String lastName);
}
