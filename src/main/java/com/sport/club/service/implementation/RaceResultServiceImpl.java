package com.sport.club.service.implementation;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sport.club.exceptions.GeneralException;
import com.sport.club.exceptions.RemoteServiceException;
import com.sport.club.http.HttpService;
import com.sport.club.model.RaceResult;
import com.sport.club.model.Rider;
import com.sport.club.pojo.request.CreateRaceResultDTO;
import com.sport.club.pojo.response.RaceResultDTO;
import com.sport.club.pojo.response.WeatherResponse;
import com.sport.club.repository.RaceResultRepository;
import com.sport.club.repository.RiderRepository;
import com.sport.club.service.RaceResultService;
import com.sport.club.service.RiderService;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
@Slf4j
public class RaceResultServiceImpl implements RaceResultService {

    @Value("${api.key}")
    private String API_KEY;

    @Value("${base.url}")
    private String BASE_URL;

    private final RaceResultRepository raceResultRepository;
    private final RiderService riderService;
    private final RiderRepository riderRepository;
    private final Gson gson;
    private final HttpService httpService;
    private final ObjectMapper objectMapper;

    @Override
    public List<Rider> getFastestThreeRiders(Long raceId) {
        log.info("Getting the Fastest Three Riders for race with ID {}", raceId);

        List<RaceResult> results = raceResultRepository.findByRaceIdOrderByPositionAsc(raceId);
        return results.stream().limit(3).map(RaceResult::getRider).collect(Collectors.toList());
    }

    @Override
    public List<RaceResult> getRaceResultForFastestThreeRiders(Long raceId) {
        log.info("Getting Race Result for the Fastest Three Riders for race with ID {}", raceId);

        return raceResultRepository.findByRaceIdOrderByPositionAsc(raceId)
                .stream()
                .limit(3)
                .toList();
    }

    @Override
    public List<Rider> getRidersWhoDidNotFinish(Long raceId) {
        log.info("Getting the Riders who did not finish for race with ID {}", raceId);

        List<RaceResult> results = raceResultRepository.findByRaceIdAndDidFinishFalse(raceId);
        return results.stream().map(RaceResult::getRider).collect(Collectors.toList());
    }

    @Override
    public List<Rider> getRidersWhoDidNotParticipate(Long raceId) {
        log.info("Getting the Riders who did not participate for race with ID {}", raceId);

        // Get all riders who participated in the race by raceId
        List<Long> riderIdsInRace = raceResultRepository.findByRaceId(raceId)
                .stream()
                .map(result -> result.getRider().getId())
                .toList();

        // Query all riders and exclude those who participated
        return riderService.getRiderList().stream()
                .filter(rider -> !riderIdsInRace.contains(rider.getId()))
                .toList();
    }


    @Override
    public WeatherResponse getWeather(String location) {
        log.info("Request to get the weather for {}", location);

        String fullUrl = BASE_URL + location + "&appid=" + API_KEY;

        String requestBody;

        try {
            requestBody = objectMapper.writeValueAsString("");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HttpResponse<JsonNode> httpResponse = httpService.post2(getHeaders(), requestBody, fullUrl);
        getResponseAsString(httpResponse);

        int status = httpResponse.getStatus();
        log.info("http status {}", status);

        return getResponse(httpResponse);
    }

    private Map<String, String> getHeaders() {
        log.info("Getting headers ...");

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public void getResponseAsString(HttpResponse<JsonNode> response) {
        log.info("getting JSON response as a string");

        if (Objects.nonNull(response)) {
            if (Objects.nonNull(response.getBody())) {
                String body = response.getBody().toPrettyString();
                log.info(body);
                return;
            }
        }
        throw new RemoteServiceException("No Response from Host");
    }

    private WeatherResponse getResponse(HttpResponse<JsonNode> httpResponse) {
        String body = httpResponse.getBody().toPrettyString();
        WeatherResponse weatherResponse;
        try {
            weatherResponse = gson.fromJson(body, WeatherResponse.class);
        } catch (JsonSyntaxException e) {
            throw new GeneralException(e.getMessage());
        }
        if (Objects.isNull(weatherResponse)) {
            throw new GeneralException("An error occurred");
        }
        return weatherResponse;
    }

}
