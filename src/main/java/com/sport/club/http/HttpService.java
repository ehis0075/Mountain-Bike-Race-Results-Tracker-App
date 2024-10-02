package com.sport.club.http;

import com.sport.club.exceptions.RemoteServiceException;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import org.springframework.http.HttpHeaders;

import java.util.Map;

public interface HttpService {

    String post(HttpHeaders headers, String uri, String payload);

    HttpResponse<String> post(Map<String, String> headerList, String jsonPayload, String url);

    HttpResponse<String> get(Map<String, String> headerList, Map<String, Object> params, String url);

    HttpResponse<String> get2(Map<String, String> headerList, Map<String, Object> params, String url);

    HttpResponse<JsonNode> getForBasicAuth(String username, String password, String url);

    HttpResponse<JsonNode> post2(Map<String, String> headerList, String jsonPayload, String url) throws RemoteServiceException;

    HttpResponse<JsonNode> getRequest(Map<String, String> headerList, String url) throws RemoteServiceException;
}
