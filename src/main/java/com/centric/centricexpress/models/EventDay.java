package com.centric.centricexpress.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class EventDay {

    @Id
    private String eventDayId;

    private List<String> events;

    private LocalDate date;

    public EventDay(LocalDate date) {
        this.date = date;
        events = new ArrayList<>();
    }

<<<<<<< HEAD
    public String getEventDayId() {
        return eventDayId;
=======
    public void addEvent(String id) {
        if (events == null) {
            events = new ArrayList<>();
        }

        events.add(id);
    }

    public String getId() {
        return id;
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412
    }

    public void setEventDayId(String eventDayId) {
        this.eventDayId = eventDayId;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
