package com.example.EventsPoster.service.impl;

import com.example.EventsPoster.repository.LocationsRepository;
import com.example.EventsPoster.service.LocationService;
import com.example.EventsPoster.service.model.LocationModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LocationServiceImpl implements LocationService {
    private final LocationsRepository repository;
    private final ModelMapper mapper = new ModelMapper();
    @Override
    public List<LocationModel> getAllLocations() {
        List<LocationModel> locationModels = new ArrayList<>();
        repository.findAll().forEach(location -> locationModels.add(mapper.map(location, LocationModel.class)));
        return locationModels;
    }
}
