package com.example.EventsPoster.service.impl;

import com.example.EventsPoster.repository.EventsRepository;
import com.example.EventsPoster.service.EventsService;
import com.example.EventsPoster.service.model.EventModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {
    private final EventsRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<EventModel> getAllEvents() {
        List<EventModel> eventModels = new ArrayList<EventModel>();
        repository.findAll().forEach(event -> eventModels.add(mapper.map(event, EventModel.class)));
        return eventModels;
    }
}
