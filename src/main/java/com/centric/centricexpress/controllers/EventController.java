package com.centric.centricexpress.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centric.centricexpress.models.Event;
import com.centric.centricexpress.models.EventAttendant;
import com.centric.centricexpress.models.EventDay;
import com.centric.centricexpress.services.EventAttendantService;
import com.centric.centricexpress.services.EventDayService;
import com.centric.centricexpress.services.EventService;

@Controller
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventAttendantService eventAttendantService;

    @Autowired
    private EventDayService eventDayService;

    @GetMapping(value = "/event/{id}")
    @ResponseBody
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @GetMapping(value = "/eventDays")
    @ResponseBody
    public List<EventDay> getEventDays() {
        return eventDayService.getAllEventDays();
    }

    @GetMapping(value = "/eventDay/{id}")
    @ResponseBody
    public List<Event> getEventsForDay(@PathVariable Long eventDayId) {
        EventDay eventDay = eventDayService.findById(eventDayId);

        List<Event> events = eventDay.getEvents()
                .stream()
                .map(id -> eventService.getEventById(id))
                .collect(Collectors.toList());

        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        });

        return events;
    }

    @GetMapping(value = "/event/{id}/attendants")
    @ResponseBody
    public List<EventAttendant> getAttendantsForEvent(@PathVariable Long eventId) {
        Event event = eventService.getEventById(eventId);

        return event.getAttendants()
                .stream()
                .map(id -> eventAttendantService.getById(id))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/eventDay")
    @ResponseBody
    public EventDay createEventDay(@RequestParam(value = "date") String date) {
        return eventDayService.createEventDay(date);
    }

    @DeleteMapping(value = "/eventDay/{eventDayId}")
    public void removeEventDay(@PathVariable(value = "eventDayId") Long eventDayId) {
        EventDay eventDay = eventDayService.findById(eventDayId);

        eventDay.getEvents()
                .stream()
                .forEach(eventId -> eventService.deleteEvent(eventId));

        eventDayService.removeEventDay(eventDayId);
    }

    @PostMapping(value = "/event")
    @ResponseBody
    public Event createEvent(@RequestParam(value = "eventDayId") Long eventDayId,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "location") String location,
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime") String endTime) {
        Event event = eventService.createEvent(name, description, location, startTime, endTime);

        eventDayService.addEvent(eventDayId, event.getId());

        return event;
    }

    @DeleteMapping(value = "/event/{eventId}")
    @ResponseBody
    public void removeEvent(@PathVariable(value = "eventId") Long eventId) {
        List<EventDay> allEventDays = eventDayService.getAllEventDays();
        Optional<EventDay> eventDayForEvent = allEventDays.stream()
                .filter(eventDay -> eventDay.getEvents().contains(eventId))
                .findFirst();

        if (eventDayForEvent.isPresent()) {
            eventDayService.removeEvent(eventId, eventDayForEvent.get().getId());
        }
    }

    @PostMapping(value = "/attendant")
    @ResponseBody
    public EventAttendant createAttendant(@RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName) {

        return eventAttendantService.create(firstName, lastName);
    }

    @PostMapping("/event/assign")
    public void assignAttendant(@RequestParam(value = "eventId") Long eventId,
            @RequestParam(value = "attendantId") Long attendantId) {

        eventService.addAttendant(eventId, attendantId);
    }

    @PostMapping("/event/remove")
    public void removeAttendant(@RequestParam(value = "eventId") Long eventId,
            @RequestParam(value = "attendantId") Long attendantId) {

        eventService.removeAttendant(eventId, attendantId);
    }
}
