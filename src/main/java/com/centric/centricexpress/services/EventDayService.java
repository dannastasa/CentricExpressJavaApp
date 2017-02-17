package com.centric.centricexpress.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.centric.centricexpress.models.Event;
import com.centric.centricexpress.models.EventDay;
import com.centric.centricexpress.repositories.EventDayRepository;
import com.centric.centricexpress.repositories.EventRepository;

public class EventDayService {
    @Autowired
    private EventDayRepository eventDayRepository;

    @Autowired
    private EventRepository eventRepository;

    public void createEventDay(String date) {
        EventDay eventDay = new EventDay(getLocalDateFromString(date));

        eventDayRepository.save(eventDay);
    }

    public void addEvent(Long eventId, Long eventDayId) {
        EventDay eventDay = eventDayRepository.findById(eventDayId);
        Event event = eventRepository.findById(eventId);

        eventDay.getEvents().add(event);
        eventDayRepository.save(eventDay);
    }

    public void removeEvent(Long eventId, Long eventDayId) {
        EventDay eventDay = eventDayRepository.findById(eventDayId);
        Event event = eventRepository.findById(eventId);

        eventDay.getEvents().remove(event);
        eventDayRepository.save(eventDay);
    }

    public EventDay findByDay(String date) {
        return eventDayRepository.findByDay(getLocalDateFromString(date));
    }

    public EventDay findById(Long id) {
        return eventDayRepository.findById(id);
    }

    public LocalDate getLocalDateFromString(String date) {
        return LocalDate.parse(date);
    }
}
