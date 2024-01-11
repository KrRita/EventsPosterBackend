package com.example.EventsPoster.controller;

import com.example.EventsPoster.dto.HoldingEventDto;
import com.example.EventsPoster.dto.PageDto;
import com.example.EventsPoster.service.HoldingEventsFilter;
import com.example.EventsPoster.service.HoldingEventsService;
import com.example.EventsPoster.service.model.HoldingEventModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/holding_events")
public class HoldingEventsController {
    private final HoldingEventsService service;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping("/{id}")
    public HoldingEventDto getHoldingEventById(@PathVariable Long id) {
        return mapper.map(service.getHoldingEventById(id), HoldingEventDto.class);
    }
    @GetMapping
    public Page<HoldingEventDto> getHoldingEventsByFilter(PageDto pageDto) {
        return service.getHoldingEventsByFilter(pageDto.getPageable(), mapper.map(pageDto, HoldingEventsFilter.class))
                .map(holding -> mapper.map(holding, HoldingEventDto.class));
    }

    @PostMapping
    public HoldingEventDto addHoldingEvent(@RequestBody HoldingEventDto dto) {
        HoldingEventModel model = mapper.map(dto,HoldingEventModel.class);
        return mapper.map(service.addHoldingEvent(model),HoldingEventDto.class);
    }

    @PutMapping("/{id}")
    public HoldingEventDto updateHoldingEvent(@PathVariable Long id, @RequestBody HoldingEventDto dto) {
        HoldingEventModel model = mapper.map(dto,HoldingEventModel.class);
       return mapper.map(service.updateHoldingEvent(id,model),HoldingEventDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteHoldingEventById(@PathVariable Long id) {
        service.deleteHoldingEventById(id);
    }
}
