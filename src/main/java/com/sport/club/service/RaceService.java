package com.sport.club.service;

import com.sport.club.model.Race;
import com.sport.club.pojo.request.CreateRaceDTO;
import com.sport.club.pojo.response.RaceDTO;

public interface RaceService {

    RaceDTO createRace(CreateRaceDTO request);

    Race getRaceByRaceId(Long raceId);
}
