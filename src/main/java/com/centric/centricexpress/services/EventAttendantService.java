package com.centric.centricexpress.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.centric.centricexpress.models.EventAttendant;
import com.centric.centricexpress.repositories.EventAttendantRepository;

public class EventAttendantService {

    @Autowired
    private EventAttendantRepository eventAttendantRepository;

    public void create(String firstName, String lastName) {
        EventAttendant attendant = new EventAttendant(firstName, lastName);

        eventAttendantRepository.save(attendant);
    }

    public EventAttendant getById(String id) {
        return eventAttendantRepository.findById(id);
    }

    public void delete(String id) {
        EventAttendant attendant = eventAttendantRepository.findById(id);
        eventAttendantRepository.delete(attendant);
    }
}
