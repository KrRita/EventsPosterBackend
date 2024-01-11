package com.example.EventsPoster.service.model;

import com.example.EventsPoster.dto.EventDto;
import com.example.EventsPoster.dto.LocationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HoldingEventModel {
    private Long id;
    private EventModel event;
    private LocationModel location;
    private Integer rating;
    private String description;
    private Integer ticketPrice;
}
