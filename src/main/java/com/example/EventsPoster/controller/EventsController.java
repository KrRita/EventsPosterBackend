package com.example.EventsPoster.controller;

import com.example.EventsPoster.dto.EventDto;
import com.example.EventsPoster.service.EventsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/events")
public class EventsController {
    private final ModelMapper mapper = new  ModelMapper();
    private final EventsService service;
    @GetMapping
    public List<EventDto> getAllEvents(){
        return service.getAllEvents().stream()
                .map(event -> mapper.map(event, EventDto.class))
                .toList();
    }
}
