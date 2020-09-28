package com.eventmaster.backend.service.event;

import com.eventmaster.backend.entity.event.Event;

import java.util.List;

public interface EventService {
    List<Event> findAllEvents();

    Event findEventById(Long id);

    void addEvent(Event event);
}
