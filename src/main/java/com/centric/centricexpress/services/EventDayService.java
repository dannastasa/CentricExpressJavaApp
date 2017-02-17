package com.centric.centricexpress.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.centric.centricexpress.models.EventDay;
import com.centric.centricexpress.repositories.EventDayRepository;

public class EventDayService {
    @Autowired
    private EventDayRepository eventDayRepository;

    public void createEventDay(String date) {
        EventDay eventDay = new EventDay(getLocalDateFromString(date));

        eventDayRepository.save(eventDay);
    }

    public void addEvent(Long eventId, Long eventDayId) {
        EventDay eventDay = eventDayRepository.findById(eventDayId);

        eventDay.getEvents().add(eventId);
        eventDayRepository.save(eventDay);
    }

    public void removeEvent(Long eventId, Long eventDayId) {
        EventDay eventDay = eventDayRepository.findById(eventDayId);

        eventDay.getEvents().remove(eventId);
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
