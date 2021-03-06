package com.eventmaster.backend.service.event;

import com.eventmaster.backend.entity.event.Category;
import com.eventmaster.backend.entity.event.Event;
import com.eventmaster.backend.repository.event.CategoryRepository;
import com.eventmaster.backend.repository.event.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;

    public EventServiceImpl(EventRepository eventRepository, CategoryRepository categoryRepository) {
        this.eventRepository = eventRepository;
        this.categoryRepository = categoryRepository;
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
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository
                .findById(id)
                .orElseThrow();
    }
}
