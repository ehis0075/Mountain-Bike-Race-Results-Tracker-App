package com.sport.club.http.implementaion;


import com.sport.club.exceptions.RemoteServiceException;
import com.sport.club.http.HttpService;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class HttpServiceImpl implements HttpService {

    private static final Logger logger = LoggerFactory.getLogger(HttpServiceImpl.class);

    private final RestTemplate restTemplate;

    @Override
    public String post(HttpHeaders headers, String uri, String payload) {
        try {
            logger.info("Making POST request to => {}", uri);

            HttpEntity<String> entity = new HttpEntity<>(payload, headers);

            ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

            return response.getBody();
        } catch (Exception e) {
            logger.error("Error reading {}", e.getMessage());
            throw new RemoteServiceException(e.getMessage());
        }
    }

    @Override
    public HttpResponse<String> post(Map<String, String> headerList, String jsonPayload, String url) {
        try {
            logger.info("Making POST request with header {}, jsonPayload {} and url {}", headerList, jsonPayload, url);
            Unirest.config().verifySsl(false);
            return Unirest.post(url)
                    .headers(headerList)
                    .body(jsonPayload)
                    .asString();
        } catch (Exception exception) {
            logger.info(exception.getMessage());
            throw new RemoteServiceException("Remote Service unreachable");
        }

    }

    @Override
    public HttpResponse<String> get(Map<String, String> headerList, Map<String, Object> params, String url) {
        try {
            logger.info("Making GET request with header {}, params {} and url {}", headerList, params, url);
            GetRequest getRequest = Unirest.get(url).headers(headerList);
            if (Objects.isNull(params)) {
                return getRequest.asString();
            } else {
                return getRequest.queryString(params).asString();
            }
        } catch (Exception exception) {
            logger.info(exception.getMessage());
            throw new RemoteServiceException("Remote Service unreachable");
        }
    }

    @Override
    public HttpResponse<String> get2(Map<String, String> headerList, Map<String, Object> params, String url) {
        try {
            logger.info("Making GET request with header {}, params {} and url {}", headerList, params, url);
            GetRequest getRequest = Unirest.get(url).headers(headerList);
            if (Objects.isNull(params)) {
                return getRequest.asString();
            } else {
                return getRequest.queryString(params).asString();
            }
        } catch (Exception exception) {
            logger.info(exception.getMessage());
            throw new RemoteServiceException("Remote Service unreachable");
        }
    }

    @Override
    public HttpResponse<JsonNode> getForBasicAuth(String username, String password, String url) {
        try {
            logger.info("Making GET request using Basic auth username {} and url {}", username, url);
            return Unirest.get(url).basicAuth(username, password).asJson();
        } catch (Exception exception) {
            logger.info(exception.getMessage());
            throw new RemoteServiceException("Remote Service unreachable");
        }
    }

    @Override
    public HttpResponse<JsonNode> post2(Map<String, String> headerList, String jsonPayload, String url) throws RemoteServiceException {

        headerList.put("Content-Type", "application/json");
        try {
            logger.info("Making POST request with header {}, jsonPayload {} and url {}", headerList, jsonPayload, url);
            return Unirest.post(url)
                    .headers(headerList)
                    .body(jsonPayload)
                    .asJson();
        } catch (Exception exception) {
            logger.info(exception.getMessage());
            throw new RemoteServiceException("Remote Service unreachable");
        }

    }

    @Override
    public HttpResponse<JsonNode> getRequest(Map<String, String> headerList, String url) throws RemoteServiceException {

        try {
            logger.info("Making GET request with headers {} and URL {}", headerList, url);

            return Unirest.get(url)
                    .headers(headerList)
                    .asJson();
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            throw new RemoteServiceException("Remote Service unreachable");
        }
    }

}
