package com.eventmaster.backend.controller.event;

import com.eventmaster.backend.controller.event.dto.EventDto;
import com.eventmaster.backend.controller.event.dto.EventDtoList;
import com.eventmaster.backend.controller.event.mapper.EventMapper;
import com.eventmaster.backend.entity.event.Event;
import com.eventmaster.backend.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @Autowired
    public EventController(EventService eventService, EventMapper eventMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
    }
    
    @GetMapping("/events")
    public ResponseEntity<EventDtoList> findAllEvents(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(eventMapper.convertToEventDtoList(eventService.findAllEvents()));
    }
}
