package com.centric.centricexpress.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centric.centricexpress.models.EventDay;
import com.centric.centricexpress.repositories.EventDayRepository;

<<<<<<< HEAD
@Service
public class EventDayService {
=======
public class EventDayService implements IEventDayService {
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412

    @Autowired
    private EventDayRepository eventDayRepository;

<<<<<<< HEAD
    public EventDay createEventDay(String date) {
=======
    @Override
    public void createEventDay(String date) {
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412
        EventDay eventDay = new EventDay(getLocalDateFromString(date));

        return eventDayRepository.save(eventDay);
    }

    public void removeEventDay(String eventDayId) {
        eventDayRepository.delete(eventDayId);
    }

<<<<<<< HEAD
    public void addEvent(String eventDayId, String eventId) {
        EventDay eventDay = eventDayRepository.findOne(eventDayId);

        System.out.println("Event day: " + eventDay);
=======
    @Override
    public void addEvent(String eventId, String eventDayId) {
        EventDay eventDay = eventDayRepository.findById(eventDayId);
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412

        eventDay.getEvents().add(eventId);
        eventDayRepository.save(eventDay);
    }

    @Override
    public void removeEvent(String eventId, String eventDayId) {
        EventDay eventDay = eventDayRepository.findOne(eventDayId);

        eventDay.getEvents().remove(eventId);
        eventDayRepository.save(eventDay);
    }

    @Override
    public EventDay findByDay(String date) {
        return eventDayRepository.findByDate(getLocalDateFromString(date));
    }

    @Override
    public EventDay findById(String id) {
        return eventDayRepository.findOne(id);
    }

<<<<<<< HEAD
    public List<EventDay> getAllEventDays() {
=======
    @Override
    public List<EventDay> findAll() {
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412
        return eventDayRepository.findAll();
    }

    private LocalDate getLocalDateFromString(String date) {
        return LocalDate.parse(date);
    }

<<<<<<< HEAD
=======
    @Override
    public EventDay saveEventDay(EventDay eventDay) {
        return eventDayRepository.save(eventDay);
    }
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412
}
