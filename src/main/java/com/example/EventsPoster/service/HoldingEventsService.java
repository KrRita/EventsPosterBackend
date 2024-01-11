package com.example.EventsPoster.service;
import com.example.EventsPoster.service.model.HoldingEventModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HoldingEventsService {
    HoldingEventModel getHoldingEventById(Long id);
    Page<HoldingEventModel> getAllHoldingEvents(Pageable pageable);
    Page<HoldingEventModel> getHoldingEventsByFilter(Pageable pageable, HoldingEventsFilter filter);
    Page<HoldingEventModel> getHoldingEventsByNameEvent(Pageable pageable, String nameEvent);
    Page<HoldingEventModel> getHoldingEventsByLocation(Pageable pageable, String nameLocation);
    HoldingEventModel addHoldingEvent(HoldingEventModel holdingEvent);
    HoldingEventModel updateHoldingEvent(Long id, HoldingEventModel holdingEvent);
    void deleteHoldingEventById(Long id);

}
