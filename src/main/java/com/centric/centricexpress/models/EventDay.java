package com.centric.centricexpress.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class EventDay {

    @Id
    private String id;

    private List<String> events;

    private LocalDate date;

    public EventDay(LocalDate date) {
        this.date = date;
        events = new ArrayList<>();
    }

    public void addEvent(String id) {
        if (events == null) {
            events = new ArrayList<>();
        }

        events.add(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
