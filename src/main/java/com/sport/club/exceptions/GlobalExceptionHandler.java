package com.sport.club.exceptions;


import com.sport.club.enums.ResponseCodeAndMessage;
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

    @ExceptionHandler({GeneralException.class})
    public final ResponseEntity<?> handleException(Exception ex) {
        log.info("Error occurred, error message is {}", ex.getMessage());

        if (ex instanceof GeneralException) {
            String responseCode = ex.getMessage();
            String message = ex.getCause().getMessage();
            log.info("Specific error message is: Response code => {} and message => {}", responseCode, message);

            Response response = generalService.prepareResponse(ex.getMessage(), ex.getCause().getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = generalService.prepareResponse(ResponseCodeAndMessage.AN_ERROR_OCCURRED_96, null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

}
