package com.sport.club.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@RequiredArgsConstructor
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String location;

    private LocalDate date;

    public Race(Long id, String name, String location, LocalDate date) {
        this.id=id;
        this.name=name;
        this.location=location;
        this.date=date;
    }
}

