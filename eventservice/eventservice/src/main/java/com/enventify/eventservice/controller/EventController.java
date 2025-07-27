package com.enventify.eventservice.controller;

import com.enventify.eventservice.model.Event;
import com.enventify.eventservice.repository.EventRepository;
import com.enventify.eventservice.service.EventCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventCacheService eventCacheService;

    @PostMapping
    public Event createEvent(@RequestBody Event event){
        return eventRepository.save(event);
    }

    @GetMapping
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id){
        Event cached = eventCacheService.getCachedEvent(id);
        if(cached != null){
            System.out.println("Redis is used.");
            return cached;
        }

        return eventRepository.findById(id)
                .map(event -> {
                    eventCacheService.cacheEvent(id, event);
                    return event;
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id){
        eventRepository.deleteById(id);
        return "Event deleted successfully.";
    }
}
