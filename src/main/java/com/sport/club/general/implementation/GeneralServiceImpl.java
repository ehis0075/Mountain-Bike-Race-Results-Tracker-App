package com.sport.club.general.implementation;

import com.google.gson.Gson;
import com.sport.club.enums.ResponseCodeAndMessage;
import com.sport.club.exceptions.RemoteServiceException;
import com.sport.club.general.GeneralService;
import com.sport.club.utils.Response;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Slf4j
@Service
public class GeneralServiceImpl implements GeneralService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Gson gson;

    public GeneralServiceImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String getAsString(Object o) {
        return gson.toJson(o);
    }

    @Override
    public String getResponseAsString(HttpResponse<JsonNode> response) {
        logger.info("getting JSON response as a string");

        if (Objects.nonNull(response)) {
            if (Objects.nonNull(response.getBody())) {
                String body = response.getBody().toPrettyString();
                logger.info(body);
                return body;
            }
        }
        throw new RemoteServiceException("No Response from Host");
    }

    @Override
    public Response prepareResponse(ResponseCodeAndMessage codeAndMessage, Object data) {
        return getResponse(codeAndMessage.responseCode, codeAndMessage.responseMessage, data);
    }

    @Override
    public Response prepareResponse(String responseCode, String responseMessage, Object data) {
        return getResponse(responseCode, responseMessage, data);
    }

    @Override
    public Response prepareFailedResponse(String message) {
        Response response = new Response();
        response.setResponseCode("96");
        response.setResponseMessage(message);

        logger.info("ResponseCode => 96 and message => {}", message);

        return response;
    }

    private Response getResponse(String responseCode, String responseMessage, Object data) {
        Response response = new Response();
        response.setResponseCode(responseCode);
        response.setResponseMessage(responseMessage);
        response.setData(data);

        log.info("ResponseCode => {}, message => {} and data => {}", responseCode, responseMessage, data);

        return response;
    }
}
