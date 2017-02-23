package com.centric.centricexpress.models;

import org.springframework.data.annotation.Id;

public class EventAttendant {

    @Id
    private String eventAttendantId;

    private String firstName;

    private String lastName;

    public EventAttendant(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEventAttendantId() {
        return eventAttendantId;
    }

    public void setEventAttendantId(String eventAttendantId) {
        this.eventAttendantId = eventAttendantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
