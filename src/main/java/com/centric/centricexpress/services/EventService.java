package com.centric.centricexpress.services;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.centric.centricexpress.models.Event;
import com.centric.centricexpress.repositories.EventRepository;

public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public void createEvent(String name, String description, String location, LocalTime startTime, LocalTime endTime) {
        Event newEvent = new Event(name, description, location, startTime, endTime);

        eventRepository.save(newEvent);
    }

    public void addAttendant(Long eventId, Long attendantId) {
        Event event = eventRepository.findById(eventId);

        event.getAttendants().add(attendantId);
        eventRepository.save(event);
    }

    public void removeAttendant(Long eventId, Long attendantId) {
        Event event = eventRepository.findById(eventId);

        event.getAttendants().remove(attendantId);
        eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.delete(id);
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id);
    }
}
