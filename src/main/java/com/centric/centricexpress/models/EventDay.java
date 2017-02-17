package com.centric.centricexpress.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventDay {
    private Long id;

    private List<Event> events;

    private LocalDate date;

    public EventDay(LocalDate date) {
        this.date = date;
        events = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
