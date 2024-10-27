package com.joschonarth.pass_in.domain.checkin.exceptions;

public class CheckInNotFoundException extends RuntimeException {
    public CheckInNotFoundException(String message) {
        super(message);
    }
}
