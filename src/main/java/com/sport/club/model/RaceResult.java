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

    private Double raceTime;  // Time taken to complete the race (null if not finished)

    private Integer position; // Position in the race

    private boolean didFinish; // True if the rider finished, false otherwise

    public RaceResult(Long id, Rider rider, Race race, double raceTime, int position, boolean didFinish) {
        this.id = id;
        this.rider = rider;
        this.race = race;
        this.raceTime = raceTime;
        this.position = position;
        this.didFinish = didFinish;
    }

    public RaceResult() {
    }

    public RaceResult(Long id, Rider rider, Race race, Double raceTime, Integer position, boolean didFinish) {
        this.id = id;
        this.rider = rider;
        this.race = race;
        this.raceTime = didFinish ? raceTime : null; // Ensure raceTime is null if didFinish is false
        this.position = position;
        this.didFinish = didFinish;
    }

    public RaceResult(long l, Rider rider1, Race race, double v, int i, boolean b) {
        this.id = l;
        this.rider = rider1;
        this.race = race;
        this.raceTime = v;
        this.position = i;
        this.didFinish = b;
    }
}

