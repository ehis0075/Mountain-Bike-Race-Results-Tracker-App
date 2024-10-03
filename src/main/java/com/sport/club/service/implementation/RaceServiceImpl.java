package com.sport.club.service.implementation;


import com.sport.club.enums.ResponseCodeAndMessage;
import com.sport.club.exceptions.GeneralException;
import com.sport.club.model.Race;
import com.sport.club.pojo.request.CreateRaceDTO;
import com.sport.club.pojo.response.RaceDTO;
import com.sport.club.repository.RaceRepository;
import com.sport.club.service.RaceService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Data
@RequiredArgsConstructor
@Slf4j
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;

    @Override
    public RaceDTO createRace(CreateRaceDTO request) {
        log.info("Creating race with request {}", request);

        Race race = raceRepository.findRaceByName(request.getName());

        if (Objects.isNull(race)) {
            race = new Race();
            race.setName(request.getName());
            race.setLocation(request.getLocation());
            race.setDate(LocalDate.parse(request.getDate()));
        } else {
            throw new GeneralException(ResponseCodeAndMessage.ALREADY_EXIST_60.responseMessage);
        }
        RaceDTO raceDTO = new RaceDTO();
        BeanUtils.copyProperties(race, raceDTO);

        return raceDTO;
    }

    @Override
    public Race getRaceByRaceId(Long raceId) {
        log.info("Getting race with ID {}", raceId);

        Race race = raceRepository.findRaceById(raceId);

        if (Objects.nonNull(race)) {
            throw new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_75.responseMessage);
        } else {
            return race;
        }
    }


}
