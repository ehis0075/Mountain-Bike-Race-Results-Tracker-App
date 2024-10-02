package com.sport.club.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResponseCodeAndMessage {

    SUCCESSFUL_0("0", "Successful"),
    INVALID_REQUEST_74("74", "Invalid Request"),
    INCOMPLETE_PARAMETERS_91("91", "Incomplete parameters"),
    REMOTE_REQUEST_FAILED_92("92", "Remote request failed"),
    AN_ERROR_OCCURRED_96("96", "An error occurred"),
    CLIENT_NOT_ALLOWED_97("97", "Client not allowed");

    public String responseCode;
    public String responseMessage;

}
