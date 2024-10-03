package com.sport.club.general;



import com.sport.club.enums.ResponseCodeAndMessage;
import com.sport.club.utils.Response;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

import java.math.BigDecimal;

public interface GeneralService {

    //Used to format object into a string
    String getAsString(Object o);

    String getResponseAsString(HttpResponse<JsonNode> response);

    Response prepareResponse(ResponseCodeAndMessage codeAndMessage, Object data);

    Response prepareResponse(String responseCode, String responseMessage, Object data);

    Response prepareFailedResponse(String message);
}
