package com.sport.club.utils;


import com.sport.club.enums.ResponseCodeAndMessage;

public class ClientUtils {
    public static Response getResponse(ResponseCodeAndMessage codeAndMessage, Object data) {
        return new Response(codeAndMessage.responseCode, codeAndMessage.responseMessage, data);
    }
}
