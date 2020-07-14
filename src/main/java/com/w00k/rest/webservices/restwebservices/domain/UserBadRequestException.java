package com.w00k.rest.webservices.restwebservices.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserBadRequestException extends RuntimeException{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public UserBadRequestException(String message) {
        super(message);
    }
}
