package com.centric.centricexpress.services;

import com.centric.centricexpress.models.EventAttendant;

public interface IEventAttendantService {

    void create(String firstName, String lastName);

    EventAttendant getById(String id);

    void delete(String id);

}