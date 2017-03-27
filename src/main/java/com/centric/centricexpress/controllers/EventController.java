package com.centric.centricexpress.controllers;

<<<<<<< HEAD
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
=======
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
=======
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412
import org.springframework.web.bind.annotation.ResponseBody;

import com.centric.centricexpress.models.Event;
import com.centric.centricexpress.models.EventAttendant;
import com.centric.centricexpress.models.EventDay;
<<<<<<< HEAD
import com.centric.centricexpress.services.EventAttendantService;
import com.centric.centricexpress.services.EventDayService;
import com.centric.centricexpress.services.EventService;
=======
import com.centric.centricexpress.services.IEventAttendantService;
import com.centric.centricexpress.services.IEventDayService;
import com.centric.centricexpress.services.IEventService;
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412

@Controller
@RequestMapping("/api/v1")
public class EventController {

    @Autowired
<<<<<<< HEAD
    private EventService eventService;

    @Autowired
    private EventAttendantService eventAttendantService;

    @Autowired
    private EventDayService eventDayService;

    @GetMapping(value = "/event/{id}")
    @ResponseBody
    public Event getEventById(@PathVariable String id) {
        return eventService.getEventById(id);
    }

    @GetMapping(value = "/eventDays")
    @ResponseBody
    public List<EventDay> getEventDays() {
        return eventDayService.getAllEventDays();
    }

    @GetMapping(value = "/eventDay/{eventDayId}")
=======
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
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412
    @ResponseBody
    public List<Event> getEventsForDay(@PathVariable String eventDayId) {
        EventDay eventDay = eventDayService.findById(eventDayId);

<<<<<<< HEAD
        List<Event> events = eventDay.getEvents()
=======
        List<Event> result = eventDay.getEvents()
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412
                .stream()
                .map(id -> eventService.getEventById(id))
                .collect(Collectors.toList());

<<<<<<< HEAD
        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        });

        return events;
    }

    @GetMapping(value = "/event/{id}/attendants")
=======
        result.sort((o1, o2) -> o1.getStartTime().compareTo(o2.getStartTime()));

        return result;
    }

    @GetMapping("/events/{eventId}/attendants")
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412
    @ResponseBody
    public List<EventAttendant> getAttendantsForEvent(@PathVariable String eventId) {
        Event event = eventService.getEventById(eventId);

<<<<<<< HEAD
        return event.getAttendants()
                .stream()
                .map(id -> eventAttendantService.getById(id))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/eventDay")
    @ResponseBody
    public EventDay createEventDay(@RequestParam String date) {
        return eventDayService.createEventDay(date);
    }

    @DeleteMapping(value = "/eventDay/{eventDayId}")
    public void removeEventDay(@PathVariable String eventDayId) {
        EventDay eventDay = eventDayService.findById(eventDayId);

        eventDay.getEvents()
                .stream()
                .forEach(eventId -> eventService.deleteEvent(eventId));

        eventDayService.removeEventDay(eventDayId);
    }

    @PostMapping(value = "/event")
    @ResponseBody
    public Event createEvent(@RequestParam String eventDayId,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "location") String location,
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime") String endTime) {
        Event event = eventService.createEvent(name, description, location, startTime, endTime);

        eventDayService.addEvent(eventDayId, event.getEventId());

        return event;
    }

    @DeleteMapping(value = "/event/{eventId}")
    @ResponseBody
    public void removeEvent(@PathVariable String eventId) {
        List<EventDay> allEventDays = eventDayService.getAllEventDays();
        Optional<EventDay> eventDayForEvent = allEventDays.stream()
                .filter(eventDay -> eventDay.getEvents().contains(eventId))
                .findFirst();

        if (eventDayForEvent.isPresent()) {
            eventDayService.removeEvent(eventId, eventDayForEvent.get().getEventDayId());
        }
    }

    @PostMapping(value = "/attendant")
    @ResponseBody
    public EventAttendant createAttendant(@RequestParam String firstName,
            @RequestParam String lastName) {

        return eventAttendantService.create(firstName, lastName);
    }

    @PostMapping("/event/assign")
    public void assignAttendant(@RequestParam String eventId,
            @RequestParam String attendantId) {

        eventService.addAttendant(eventId, attendantId);
    }

    @PostMapping("/event/remove")
    public void removeAttendant(@RequestParam String eventId,
            @RequestParam String attendantId) {

        eventService.removeAttendant(eventId, attendantId);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        String errorMessage = "Wrong date format! The proper format for day is: YYYY-MM-DD, and for time: HH:MM:SS";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
=======
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
>>>>>>> 2e0b0d3ee21a6aab53f846432dc0aaaa24627412
}
