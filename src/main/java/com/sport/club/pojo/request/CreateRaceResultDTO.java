package com.sport.club.pojo.request;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CreateRaceResultDTO {

    private Long riderId;

    private Long raceId;

    private String raceTime;

    private Integer position;

    private boolean didFinish;

}

