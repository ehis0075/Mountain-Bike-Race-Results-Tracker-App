package com.sport.club.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RaceResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rider_id")
    private Rider rider;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    private String raceTime;  // Time taken to complete the race (null if not finished)

    private Integer position; // Position in the race

    private boolean didFinish; // True if the rider finished, false otherwise

}

