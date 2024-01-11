package com.example.EventsPoster.repository;

import com.example.EventsPoster.entity.Event;
import com.example.EventsPoster.entity.HoldingEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EventsRepository extends CrudRepository<Event,Long> {
    Optional<Event> findByName(String nameEvent);
}
