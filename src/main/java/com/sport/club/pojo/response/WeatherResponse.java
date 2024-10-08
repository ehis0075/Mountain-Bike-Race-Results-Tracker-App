package com.sport.club.pojo.response;

import lombok.Getter;

import java.util.List;

@Getter
public class WeatherResponse {

    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Mainz main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private long id;
    private String name;
    private int cod;

}

