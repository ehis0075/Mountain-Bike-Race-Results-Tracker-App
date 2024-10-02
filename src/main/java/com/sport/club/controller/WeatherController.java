package com.sport.club.controller;


import com.sport.club.enums.ResponseCodeAndMessage;
import com.sport.club.general.GeneralService;
import com.sport.club.model.RaceResult;
import com.sport.club.model.Rider;
import com.sport.club.pojo.WeatherResponse;
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
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final GeneralService generalService;
    private final RaceResultService raceResultService;

    @GetMapping("/{raceLocation}")
    public Response getWeatherForRaceLocation(@PathVariable String raceLocation) {
        WeatherResponse data = raceResultService.getWeather(raceLocation);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

}
