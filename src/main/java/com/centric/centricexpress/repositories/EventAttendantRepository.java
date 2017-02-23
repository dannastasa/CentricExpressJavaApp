package com.centric.centricexpress.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.centric.centricexpress.models.EventAttendant;

@Repository
public interface EventAttendantRepository extends MongoRepository<EventAttendant, String> {

    List<EventAttendant> findByLastName(String lastName);

    List<EventAttendant> findByFirstName(String firstName);

    List<EventAttendant> findByFirstNameOrLastName(String firstName, String lastName);
}
