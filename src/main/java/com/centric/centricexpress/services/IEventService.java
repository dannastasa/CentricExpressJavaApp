package com.centric.centricexpress.services;

import com.centric.centricexpress.models.Event;

public interface IEventService {

    Event createEvent(String name, String description, String location, String startTime, String endTime);

    void addAttendant(String eventId, String attendantId);

    void removeAttendant(String eventId, String attendantId);

    void deleteEvent(Long id);

    Event getEventById(String id);

}