package com.enventify.eventservice.service;

import com.enventify.eventservice.model.Event;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class EventCacheService {

    private final RedisTemplate<String, Object> redisTemplate;

    public EventCacheService(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public void cacheEvent(Long eventId, Event event){
        redisTemplate.opsForValue().set("event:"+eventId, event, Duration.ofSeconds(10));
    }

    public Event getCachedEvent(Long eventId) {
        return (Event) redisTemplate.opsForValue().get("event:" + eventId);
    }
}
