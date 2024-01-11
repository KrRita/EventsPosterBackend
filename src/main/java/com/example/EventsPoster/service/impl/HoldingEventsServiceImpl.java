package com.example.EventsPoster.service.impl;

import com.example.EventsPoster.entity.Event;
import com.example.EventsPoster.entity.HoldingEvent;
import com.example.EventsPoster.entity.Location;
import com.example.EventsPoster.repository.EventsRepository;
import com.example.EventsPoster.repository.HoldingEventRepository;
import com.example.EventsPoster.repository.LocationsRepository;
import com.example.EventsPoster.service.HoldingEventsFilter;
import com.example.EventsPoster.service.HoldingEventsService;
import com.example.EventsPoster.service.model.HoldingEventModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class HoldingEventsServiceImpl implements HoldingEventsService {
    private final HoldingEventRepository holdingRepository;
    private final EventsRepository eventRepository;
    private final LocationsRepository locationRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public HoldingEventModel getHoldingEventById(Long id) {
        HoldingEvent holdingEvent = holdingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no product with id = " + id));
        return mapper.map(holdingEvent, HoldingEventModel.class);
    }

    @Override
    public Page<HoldingEventModel> getAllHoldingEvents(Pageable pageable) {
        return holdingRepository.findAll(pageable).map(holding -> mapper.map(holding, HoldingEventModel.class));
    }

    @Override
    public Page<HoldingEventModel> getHoldingEventsByFilter(Pageable pageable, HoldingEventsFilter filter) {
        return holdingRepository.findAllByFilter
                (//filter.getDateTime(),
                        filter.getEventType(),
                        filter.getTicketPrice(),
                        filter.getAgeViewer(),
                        filter.getLocation()!=null?filter.getLocation().getName():null,
                        pageable).map(holding -> mapper.map(holding, HoldingEventModel.class));
    }

    @Override
    public Page<HoldingEventModel> getHoldingEventsByNameEvent(Pageable pageable, String nameEvent) {
        return holdingRepository.findAllByEvent_Name(nameEvent, pageable)
                .map(holding -> mapper.map(holding, HoldingEventModel.class));
    }

    @Override
    public Page<HoldingEventModel> getHoldingEventsByLocation(Pageable pageable, String nameLocation) {
        return holdingRepository.findAllByLocation_Name(nameLocation, pageable)
                .map(holding -> mapper.map(holding, HoldingEventModel.class));
    }
    @Override
    public HoldingEventModel addHoldingEvent(HoldingEventModel holdingEventModel) {
        HoldingEvent holdingEntity = mapper.map(holdingEventModel, HoldingEvent.class);
        Event event = eventRepository.findByName(holdingEventModel.getEvent().getName()).orElseThrow();
        Location location = locationRepository.findByName(holdingEventModel.getLocation().getName()).orElseThrow();
        holdingEntity.setEvent(event);
        holdingEntity.setLocation(location);
        holdingEntity = holdingRepository.save(holdingEntity);
        return mapper.map(holdingEntity, HoldingEventModel.class);
    }
    @Override
    public HoldingEventModel updateHoldingEvent(Long id, HoldingEventModel holdingEvent) {
        if (!holdingRepository.existsById(id)) {
            throw new RuntimeException("Holding event with id = " + id + " must be created.");
        }
        HoldingEvent holdingEntity = holdingRepository.findById(id).orElseThrow();
        Event event = eventRepository.findByName(holdingEvent.getEvent().getName()).orElseThrow();
        Location location = locationRepository.findByName(holdingEvent.getLocation().getName()).orElseThrow();
        holdingEntity.setEvent(event);
        holdingEntity.setLocation(location);
        holdingEntity.setDescription(holdingEvent.getDescription());
        holdingEntity.setTicketPrice(holdingEvent.getTicketPrice());
        holdingEntity.setRating(holdingEvent.getRating());
        holdingEntity = holdingRepository.save(holdingEntity);
        return mapper.map(holdingEntity, HoldingEventModel.class);
    }

    @Override
    public void deleteHoldingEventById(Long id) {
        if (!holdingRepository.existsById(id)) {
            throw new RuntimeException("Holding event with id = " + id + " cannot be deleted.");
        }
        holdingRepository.deleteById(id);
    }
}
