package com.centric.centricexpress.services;

import java.util.List;

import com.centric.centricexpress.models.EventDay;

public interface IEventDayService {

    void createEventDay(String date);

    void addEvent(String eventId, String eventDayId);

    void removeEvent(String eventId, String eventDayId);

    EventDay findByDay(String date);

    EventDay findById(String id);

    List<EventDay> findAll();

    EventDay saveEventDay(EventDay eventDay);
}