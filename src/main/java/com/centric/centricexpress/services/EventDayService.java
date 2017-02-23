package com.centric.centricexpress.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centric.centricexpress.models.EventDay;
import com.centric.centricexpress.repositories.EventDayRepository;

@Service
public class EventDayService {

    @Autowired
    private EventDayRepository eventDayRepository;

    public EventDay createEventDay(String date) {
        EventDay eventDay = new EventDay(getLocalDateFromString(date));

        return eventDayRepository.save(eventDay);
    }

    public void removeEventDay(String eventDayId) {
        eventDayRepository.delete(eventDayId);
    }

    public void addEvent(String eventDayId, String eventId) {
        EventDay eventDay = eventDayRepository.findOne(eventDayId);

        System.out.println("Event day: " + eventDay);

        eventDay.getEvents().add(eventId);
        eventDayRepository.save(eventDay);
    }

    public void removeEvent(String eventId, String eventDayId) {
        EventDay eventDay = eventDayRepository.findOne(eventDayId);

        eventDay.getEvents().remove(eventId);
        eventDayRepository.save(eventDay);
    }

    public EventDay findByDay(String date) {
        return eventDayRepository.findByDate(getLocalDateFromString(date));
    }

    public EventDay findById(String id) {
        return eventDayRepository.findOne(id);
    }

    public List<EventDay> getAllEventDays() {
        return eventDayRepository.findAll();
    }

    private LocalDate getLocalDateFromString(String date) {
        return LocalDate.parse(date);
    }

}
