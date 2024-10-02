package com.sport.club.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Response {
    private String responseCode;
    private String responseMessage;
    private Object data;

    public Response() {

    }
}

