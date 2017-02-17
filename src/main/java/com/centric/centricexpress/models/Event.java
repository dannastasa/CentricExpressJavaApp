package com.centric.centricexpress.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private Long id;

    private String name;

    private String description;

    private String location;

    private LocalTime startTime;

    private LocalTime endTime;

    private List<EventAttendant> attendants;

    public Event(String name, String description, String location, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        attendants = new ArrayList<>();
    }

    @Override
    public boolean equals(Object other) {
        Event otherEvent = (Event) other;
        return id == otherEvent.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<EventAttendant> getAttendants() {
        return attendants;
    }

    public void setAttendants(List<EventAttendant> attendants) {
        this.attendants = attendants;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
