package com.sport.club.controller;


import com.sport.club.enums.ResponseCodeAndMessage;
import com.sport.club.general.GeneralService;
import com.sport.club.pojo.request.CreateRaceDTO;
import com.sport.club.pojo.response.RaceDTO;
import com.sport.club.service.RaceService;
import com.sport.club.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/races")
public class RaceController {

    private final GeneralService generalService;
    private final RaceService raceService;

    @GetMapping("/create")
    public Response createRace(@RequestBody CreateRaceDTO createRaceDTO) {

        RaceDTO data = raceService.createRace(createRaceDTO);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

}
