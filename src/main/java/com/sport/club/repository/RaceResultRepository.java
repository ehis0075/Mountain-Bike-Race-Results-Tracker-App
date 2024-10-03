package com.sport.club.repository;

import com.sport.club.model.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {

    List<RaceResult> findByRaceIdAndDidFinishTrueOrderByRaceTimeAsc(Long raceId);

    List<RaceResult> findByRaceIdOrderByPositionAsc(Long raceId);

    List<RaceResult> findByRaceIdAndDidFinishFalse(Long raceId);

    List<RaceResult> findByRaceId(Long raceId);
}
