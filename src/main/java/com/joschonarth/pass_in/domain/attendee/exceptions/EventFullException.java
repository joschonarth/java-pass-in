package com.joschonarth.pass_in.domain.attendee.exceptions;

public class EventFullException extends RuntimeException {
    public EventFullException(String message) {
        super(message);
    }
}
