package com.centric.centricexpress.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centric.centricexpress.models.EventAttendant;
import com.centric.centricexpress.repositories.EventAttendantRepository;

@Service
public class EventAttendantService {
    @Autowired
    private EventAttendantRepository eventAttendantRepository;

    public EventAttendant create(String firstName, String lastName) {
        EventAttendant attendant = new EventAttendant(firstName, lastName);

        return eventAttendantRepository.save(attendant);
    }

    public EventAttendant getById(Long id) {
        return eventAttendantRepository.findById(id);
    }

    public void delete(Long id) {
        eventAttendantRepository.delete(id);
    }
}
