package com.sport.club.pojo.response;

import com.sport.club.model.Race;
import com.sport.club.model.Rider;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class RaceResultDTO {

    private Rider rider;

    private Race race;

    private String raceTime;

    private Integer position;

    private boolean didFinish;

}

