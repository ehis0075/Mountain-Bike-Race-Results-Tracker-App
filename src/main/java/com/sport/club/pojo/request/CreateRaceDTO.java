package com.sport.club.pojo.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateRaceDTO {

    private String name;

    private String location;

    private String date;
}
