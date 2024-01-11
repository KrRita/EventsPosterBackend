package com.example.EventsPoster.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "holding_event")
public class HoldingEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "holding_event_id")
    private Long id;
    @ManyToOne
    private Event event;
    @ManyToOne
    private Location location;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "description")
    private String description;
    @Column(name = "ticket_price")
    private Integer ticketPrice;

    /*@Column(name = "data_time")
    private LocalDate dateTime;*/
}
