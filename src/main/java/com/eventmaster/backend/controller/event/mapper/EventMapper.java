package com.eventmaster.backend.controller.event.mapper;

import com.eventmaster.backend.controller.event.dto.EventDto;
import com.eventmaster.backend.controller.event.dto.EventDtoList;
import com.eventmaster.backend.entity.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {

    private final CategoryMapper categoryMapper;

    @Autowired
    public EventMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public Event map (EventDto eventDto){
        return Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .price(eventDto.getPrice())
                .location(eventDto.getLocation())
                .dateFrom(eventDto.getDateFrom())
                .dateUntil(eventDto.getDateUntil())
                .build();
    }

    public EventDto map (Event event){
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .price(event.getPrice())
                .location(event.getLocation())
                .dateFrom(event.getDateFrom())
                .dateUntil(event.getDateUntil())
                .category(categoryMapper.map(event.getCategory()))
                .build();
    }

    public EventDtoList convertToEventDtoList(List<Event> events){
        return EventDtoList.builder()
                .eventList(events.stream().map(this::map).collect(Collectors.toList()))
                .build();
    }


}
