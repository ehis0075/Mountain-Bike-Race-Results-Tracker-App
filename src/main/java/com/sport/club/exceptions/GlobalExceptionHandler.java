package com.sport.club.exceptions;


import com.sport.club.general.GeneralService;
import com.sport.club.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final GeneralService generalService;

    @ExceptionHandler({GeneralException.class, RemoteServiceException.class})
    public final ResponseEntity<?> handleException(Exception ex) {
        log.info("Error occurred, error message is {}", ex.getMessage());

        Response response = generalService.prepareFailedResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
