package com.example.EventsPoster.service.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventModel {
    private String eventType;
    private String name;
    private Integer ageViewer;
}
