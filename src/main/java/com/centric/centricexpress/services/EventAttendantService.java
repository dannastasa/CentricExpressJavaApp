package com.centric.centricexpress.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.centric.centricexpress.models.EventAttendant;
import com.centric.centricexpress.repositories.EventAttendantRepository;

public class EventAttendantService implements IEventAttendantService {

    @Autowired
    private EventAttendantRepository eventAttendantRepository;

    @Override
    public void create(String firstName, String lastName) {
        EventAttendant attendant = new EventAttendant(firstName, lastName);

        eventAttendantRepository.save(attendant);
    }

    @Override
    public EventAttendant getById(String id) {
        return eventAttendantRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        EventAttendant attendant = eventAttendantRepository.findById(id);
        eventAttendantRepository.delete(attendant);
    }
}
