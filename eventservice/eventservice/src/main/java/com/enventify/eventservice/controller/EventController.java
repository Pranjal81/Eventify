package com.enventify.eventservice.controller;

import com.enventify.eventservice.model.Event;
import com.enventify.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping
    public Event createEvent(@RequestBody Event event){
        return eventRepository.save(event);
    }

    @GetMapping
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id){
        eventRepository.deleteById(id);
        return "Event deleted successfully.";
    }
}
