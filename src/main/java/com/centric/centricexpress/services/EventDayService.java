package com.centric.centricexpress.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.centric.centricexpress.models.EventDay;
import com.centric.centricexpress.repositories.EventDayRepository;

public class EventDayService implements IEventDayService {

    @Autowired
    private EventDayRepository eventDayRepository;

    @Override
    public void createEventDay(String date) {
        EventDay eventDay = new EventDay(getLocalDateFromString(date));

        eventDayRepository.save(eventDay);
    }

    @Override
    public void addEvent(String eventId, String eventDayId) {
        EventDay eventDay = eventDayRepository.findById(eventDayId);

        eventDay.getEvents().add(eventId);
        eventDayRepository.save(eventDay);
    }

    @Override
    public void removeEvent(String eventId, String eventDayId) {
        EventDay eventDay = eventDayRepository.findById(eventDayId);

        eventDay.getEvents().remove(eventId);
        eventDayRepository.save(eventDay);
    }

    @Override
    public EventDay findByDay(String date) {
        return eventDayRepository.findByDate(getLocalDateFromString(date));
    }

    @Override
    public EventDay findById(String id) {
        return eventDayRepository.findById(id);
    }

    @Override
    public List<EventDay> findAll() {
        return eventDayRepository.findAll();
    }

    private LocalDate getLocalDateFromString(String date) {
        return LocalDate.parse(date);
    }

    @Override
    public EventDay saveEventDay(EventDay eventDay) {
        return eventDayRepository.save(eventDay);
    }
}
