package com.centric.centricexpress.services;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centric.centricexpress.models.Event;
import com.centric.centricexpress.repositories.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(String name, String description, String location, String startTime, String endTime) {
        Event newEvent = new Event(name, description, location, getTimeFromString(startTime),
                getTimeFromString(endTime));

        return eventRepository.save(newEvent);
    }

    public void addAttendant(String eventId, String attendantId) {
        Event event = eventRepository.findById(eventId);

        event.getAttendants().add(attendantId);
        eventRepository.save(event);
    }

    public void removeAttendant(String eventId, String attendantId) {
        Event event = eventRepository.findById(eventId);

        event.getAttendants().remove(attendantId);
        eventRepository.save(event);
    }

    public void deleteEvent(String id) {
        Event event = eventRepository.findById(id);
        eventRepository.delete(event);
    }

    public Event getEventById(String id) {
        return eventRepository.findById(id);
    }

    private LocalTime getTimeFromString(String time) {
        return LocalTime.parse(time);
    }
}
