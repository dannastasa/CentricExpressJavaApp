package com.centric.centricexpress.services;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.centric.centricexpress.models.Event;
import com.centric.centricexpress.repositories.EventRepository;

public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent(String name, String description, String location, String startTime, String endTime) {
        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);
        Event newEvent = new Event(name, description, location, start, end);

        return eventRepository.save(newEvent);
    }

    @Override
    public void addAttendant(String eventId, String attendantId) {
        Event event = eventRepository.findById(eventId);

        event.getAttendants().add(attendantId);
        eventRepository.save(event);
    }

    @Override
    public void removeAttendant(String eventId, String attendantId) {
        Event event = eventRepository.findById(eventId);

        event.getAttendants().remove(attendantId);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.delete(id);
    }

    @Override
    public Event getEventById(String id) {
        return eventRepository.findById(id);
    }
}
