package com.example.EventsPoster.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HoldingEventDto {
    private Long id;
    private EventDto event;
    private LocationDto location;
    private Integer rating;
    private String description;
    private Integer ticketPrice;
}
