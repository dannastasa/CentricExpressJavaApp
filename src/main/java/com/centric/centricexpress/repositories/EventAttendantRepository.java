package com.centric.centricexpress.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.centric.centricexpress.models.EventAttendant;

@Repository
<<<<<<< Updated upstream
public interface EventAttendantRepository extends MongoRepository<EventAttendant, Long> {
=======
public interface EventAttendantRepository extends MongoRepository<EventAttendant, String> {
    EventAttendant findById(String id);

    List<EventAttendant> findByLastName(String lastName);

    List<EventAttendant> findByFirstName(String firstName);

    List<EventAttendant> findByFirstNameOrLastName(String firstName, String lastName);
>>>>>>> Stashed changes

    List<EventAttendant> findByFirstName(String firstName);

    List<EventAttendant> findByFirstNameOrLastName(String firstName, String lastName);

    List<EventAttendant> findByFirstNameAndLastName(String firstName, String lastName);
}
