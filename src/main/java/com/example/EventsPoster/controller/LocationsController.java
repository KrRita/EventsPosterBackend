package com.example.EventsPoster.controller;

import com.example.EventsPoster.dto.LocationDto;
import com.example.EventsPoster.service.LocationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/locations")
public class LocationsController {
    private final LocationService service;
    private final ModelMapper mapper = new ModelMapper();;
    @GetMapping
    public List<LocationDto> getAllLocations(){
        return service.getAllLocations().stream()
                .map(location -> mapper.map(location, LocationDto.class))
                .toList();
    }
}
