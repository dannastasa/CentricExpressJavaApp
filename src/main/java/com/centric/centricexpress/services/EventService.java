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

    private LocalTime getTimeFromString(String time) {
        return LocalTime.parse(time);
    }
}
