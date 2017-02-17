package com.centric.centricexpress.models;

import java.time.LocalTime;
import java.util.List;

public class Event {
    private Long id;

    private String name;

    private String description;

    private String location;

    private LocalTime startTime;

    private LocalTime endTime;

    private List<EventAttendant> attendats;

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

    public List<EventAttendant> getAttendats() {
        return attendats;
    }

    public void setAttendats(List<EventAttendant> attendats) {
        this.attendats = attendats;
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
