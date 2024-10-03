package com.sport.club.service;

import com.sport.club.model.RaceResult;
import com.sport.club.model.Rider;
import com.sport.club.pojo.request.CreateRaceResultDTO;
import com.sport.club.pojo.response.RaceResultDTO;
import com.sport.club.pojo.response.WeatherResponse;

import java.util.List;

public interface RaceResultService {

    List<Rider> getFastestThreeRiders(Long raceId); //Fastest 3 Riders per Race

    List<RaceResult> getRaceResultForFastestThreeRiders(Long raceId);

    List<Rider> getRidersWhoDidNotFinish(Long raceId); // Riders That Did Not Finish

    List<Rider> getRidersWhoDidNotParticipate(Long raceId); // Riders Who Did Not Take Part WeatherResponse getWeather(String location);

    WeatherResponse getWeather(String location);

//    String getWeather(String location) throws InterruptedException;
}
