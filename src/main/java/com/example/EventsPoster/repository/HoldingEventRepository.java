package com.example.EventsPoster.repository;

import com.example.EventsPoster.entity.HoldingEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface HoldingEventRepository extends PagingAndSortingRepository<HoldingEvent,Long>, CrudRepository<HoldingEvent,Long> {
    @Query("SELECT h FROM HoldingEvent h WHERE " +
            "( :eventType IS NULL OR h.event.eventType ILIKE %:eventType%) AND" +
            "( :ticketPrice IS NULL OR h.ticketPrice <= :ticketPrice) AND" +
            "( :ageViewer IS NULL OR h.event.ageViewer >= :ageViewer) AND" +
            "( :location IS NULL OR h.location.name = :location)")
    Page<HoldingEvent> findAllByFilter(
            String eventType,
            Integer ticketPrice,
            Integer ageViewer,
            String location,
            Pageable pageable
    );
    Page<HoldingEvent> findAllByEvent_Name(String nameEvent,Pageable pageable);
    Page<HoldingEvent> findAllByLocation_Name(String nameLocation,Pageable pageable);
}
