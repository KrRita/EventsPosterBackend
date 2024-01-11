package com.example.EventsPoster.service;

import com.example.EventsPoster.service.model.LocationModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class HoldingEventsFilter {
    String eventType;
    Integer ticketPrice;
    Integer ageViewer;
    LocationModel location;
}
