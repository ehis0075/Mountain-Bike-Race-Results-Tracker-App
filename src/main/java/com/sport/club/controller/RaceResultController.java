package com.sport.club.controller;


import com.sport.club.enums.ResponseCodeAndMessage;
import com.sport.club.general.GeneralService;
import com.sport.club.model.RaceResult;
import com.sport.club.model.Rider;
import com.sport.club.service.RaceResultService;
import com.sport.club.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/race-results")
public class RaceResultController {

    private final GeneralService generalService;
    private final RaceResultService raceResultService;

    @GetMapping("/top3/riders/{raceId}")
    public Response getFastestThreeRiders(@PathVariable Long raceId) {

        List<Rider> data = raceResultService.getFastestThreeRiders(raceId);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

    @GetMapping("/top3/{raceId}")
    public Response getRaceResultForFastestThreeRiders(@PathVariable Long raceId) {

        List<RaceResult> data = raceResultService.getRaceResultForFastestThreeRiders(raceId);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

    @GetMapping("/did-not-finish/{raceId}")
    public Response getRidersWhoDidNotFinish(@PathVariable Long raceId) {

        List<Rider> data = raceResultService.getRidersWhoDidNotFinish(raceId);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

    @GetMapping("/not-participated/{raceId}")
    public Response getRidersWhoDidNotParticipate(@PathVariable Long raceId) {

        List<Rider> data = raceResultService.getRidersWhoDidNotParticipate(raceId);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

}
