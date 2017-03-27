package com.centric.centricexpress.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centric.centricexpress.models.EventAttendant;
import com.centric.centricexpress.repositories.EventAttendantRepository;

<<<<<<< HEAD
@Service
public class EventAttendantService {
=======
public class EventAttendantService implements IEventAttendantService {
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412

    @Autowired
    private EventAttendantRepository eventAttendantRepository;

<<<<<<< HEAD
    public EventAttendant create(String firstName, String lastName) {
=======
    @Override
    public void create(String firstName, String lastName) {
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412
        EventAttendant attendant = new EventAttendant(firstName, lastName);

        return eventAttendantRepository.save(attendant);
    }

    @Override
    public EventAttendant getById(String id) {
        return eventAttendantRepository.findOne(id);
    }

    @Override
    public void delete(String id) {
        EventAttendant attendant = eventAttendantRepository.findOne(id);
        eventAttendantRepository.delete(attendant);
    }
}
