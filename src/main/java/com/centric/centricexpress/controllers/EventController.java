package com.centric.centricexpress.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centric.centricexpress.models.Event;
import com.centric.centricexpress.models.EventAttendant;
import com.centric.centricexpress.models.EventDay;
import com.centric.centricexpress.services.IEventAttendantService;
import com.centric.centricexpress.services.IEventDayService;
import com.centric.centricexpress.services.IEventService;

@Controller
@RequestMapping("/api/v1")
public class EventController {

    @Autowired
    private IEventService eventService;
    @Autowired
    private IEventAttendantService eventAttendantService;
    @Autowired
    private IEventDayService eventDayService;

    @GetMapping("/eventdays")
    @ResponseBody
    public List<EventDay> getEventDays() {
        return eventDayService.findAll();
    }

    @GetMapping("/event/{eventId}")
    @ResponseBody
    public Event getEventById(@PathVariable String eventId) {
        return eventService.getEventById(eventId);
    }

    @GetMapping("/eventdays/{eventDayId}")
    @ResponseBody
    public List<Event> getEventsForDay(@PathVariable String eventDayId) {
        EventDay eventDay = eventDayService.findById(eventDayId);

        List<Event> result = eventDay.getEvents()
                .stream()
                .map(id -> eventService.getEventById(id))
                .collect(Collectors.toList());

        result.sort((o1, o2) -> o1.getStartTime().compareTo(o2.getStartTime()));

        return result;
    }

    @GetMapping("/events/{eventId}/attendants")
    @ResponseBody
    public List<EventAttendant> getAttendantsForEvent(@PathVariable String eventId) {
        Event event = eventService.getEventById(eventId);

        List<EventAttendant> result = event.getAttendants()
                .stream()
                .map(id -> eventAttendantService.getById(id))
                .collect(Collectors.toList());

        return result;
    }

    @PostMapping("/events")
    @ResponseBody
    public Event createEvent(String eventDayId, String name, String description, String location, String startTime,
            String endTime) {
        Event event = eventService.createEvent(name, description, location, startTime, endTime);
        EventDay eventDay = eventDayService.findById(eventDayId);

        eventDay.addEvent(event.getId());
        eventDayService.saveEventDay(eventDay);

        return event;
    }
}
