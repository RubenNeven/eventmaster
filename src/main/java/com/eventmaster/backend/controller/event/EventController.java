package com.eventmaster.backend.controller.event;

import com.eventmaster.backend.controller.event.dto.CategoryDtoList;
import com.eventmaster.backend.controller.event.dto.EventDto;
import com.eventmaster.backend.controller.event.dto.EventDtoList;
import com.eventmaster.backend.controller.event.mapper.CategoryMapper;
import com.eventmaster.backend.controller.event.mapper.EventMapper;
import com.eventmaster.backend.entity.event.Event;
import com.eventmaster.backend.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;
    private final CategoryMapper categoryMapper;


    @Autowired
    public EventController(EventService eventService, EventMapper eventMapper, CategoryMapper categoryMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
        this.categoryMapper = categoryMapper;
    }
    
    @GetMapping("/events")
    public ResponseEntity<EventDtoList> findAllEvents(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(eventMapper.convertToEventDtoList(eventService.findAllEvents()));
    }

    @GetMapping("/categories")
    public ResponseEntity<CategoryDtoList> findAllCategories(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryMapper.convertToCategoryDtoList(eventService.findAllCategories().stream().collect(Collectors.toList())));
    }


    
    @PostMapping("/events")
    public Event addEvent(@RequestBody EventDto eventDto){
        return eventService.addEvent(eventMapper.map(eventDto));
    }

    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
    }
}
