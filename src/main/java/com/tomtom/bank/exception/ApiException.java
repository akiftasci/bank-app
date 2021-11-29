package com.tomtom.bank.exception;

import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@RequiredArgsConstructor
public class ApiException {
    private final String message;
    private final int statuscode;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

}
