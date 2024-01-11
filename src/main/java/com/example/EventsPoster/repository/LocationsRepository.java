package com.example.EventsPoster.repository;

import com.example.EventsPoster.entity.Event;
import com.example.EventsPoster.entity.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationsRepository extends CrudRepository<Location,Long>{
    Optional<Location> findByName(String nameLocation);
}
