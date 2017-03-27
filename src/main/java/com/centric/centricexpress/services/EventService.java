package com.centric.centricexpress.services;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centric.centricexpress.models.Event;
import com.centric.centricexpress.repositories.EventRepository;

<<<<<<< HEAD
@Service
public class EventService {
=======
public class EventService implements IEventService {
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412

    @Autowired
    private EventRepository eventRepository;

<<<<<<< HEAD
    public Event createEvent(String name, String description, String location, String startTime, String endTime) {
        Event newEvent = new Event(name, description, location, getTimeFromString(startTime),
                getTimeFromString(endTime));
=======
    @Override
    public Event createEvent(String name, String description, String location, String startTime, String endTime) {
        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);
        Event newEvent = new Event(name, description, location, start, end);
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412

        return eventRepository.save(newEvent);
    }

    @Override
    public void addAttendant(String eventId, String attendantId) {
        Event event = eventRepository.findOne(eventId);

        event.getAttendants().add(attendantId);
        eventRepository.save(event);
    }

    @Override
    public void removeAttendant(String eventId, String attendantId) {
        Event event = eventRepository.findOne(eventId);

        event.getAttendants().remove(attendantId);
        eventRepository.save(event);
    }

<<<<<<< HEAD
    public void deleteEvent(String id) {
        Event event = eventRepository.findOne(id);
        eventRepository.delete(event);
=======
    @Override
    public void deleteEvent(Long id) {
        eventRepository.delete(id);
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412
    }

    @Override
    public Event getEventById(String id) {
        return eventRepository.findOne(id);
    }

    private LocalTime getTimeFromString(String time) {
        return LocalTime.parse(time);
    }
}
