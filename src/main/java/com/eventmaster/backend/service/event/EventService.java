package com.eventmaster.backend.service.event;

import com.eventmaster.backend.entity.event.Category;
import com.eventmaster.backend.entity.event.Event;

import java.util.List;

public interface EventService {
    List<Event> findAllEvents();

    Event findEventById(Long id);

    Event addEvent(Event event);

    void deleteEvent(Long id);

    List<Category> findAllCategories();

    Category findCategoryById(Long id);
}
