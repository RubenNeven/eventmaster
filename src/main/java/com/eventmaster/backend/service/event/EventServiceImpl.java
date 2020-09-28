package com.eventmaster.backend.service.event;

import com.eventmaster.backend.entity.event.Event;
import com.eventmaster.backend.repository.event.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event findEventById(Long id) {
        return eventRepository
                .findById(id)
                .orElseThrow();
    }

    @Override
    public void addEvent(Event event) {
        eventRepository.save(event);
    }
}
