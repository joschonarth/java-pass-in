package com.joschonarth.pass_in.config;

import com.joschonarth.pass_in.domain.attendee.exceptions.AttendeeAlreadyExistsException;
import com.joschonarth.pass_in.domain.attendee.exceptions.AttendeeNotFoundException;
import com.joschonarth.pass_in.domain.checkin.exceptions.CheckInAlreadyExistsException;
import com.joschonarth.pass_in.domain.event.exceptions.EventFullException;
import com.joschonarth.pass_in.domain.event.exceptions.EventNotFoundException;
import com.joschonarth.pass_in.dto.general.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEntityHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<String> handleEventNotFound(EventNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(EventFullException.class)
    public ResponseEntity<ErrorResponseDTO> handleEventFull(EventFullException exception) {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(exception.getMessage()));
    }

//    @ExceptionHandler(AttendeeNotFoundException.class)
//    public ResponseEntity handleAttendeeNotFound(AttendeeNotFoundException exception) {
//        return ResponseEntity.notFound().build();
//    }

    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleAttendeeNotFound(AttendeeNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDTO(exception.getMessage()));
    }

//    @ExceptionHandler(AttendeeAlreadyExistsException.class)
//    public ResponseEntity handleAttendeeAlreadyExists(AttendeeAlreadyExistsException exception) {
//        return ResponseEntity.status(HttpStatus.CONFLICT).build();
//    }

    @ExceptionHandler(AttendeeAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleAttendeeAlreadyExists(AttendeeAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponseDTO(exception.getMessage()));
    }

//    @ExceptionHandler(CheckInAlreadyExistsException.class)
//    public ResponseEntity handleCheckInAlreadyExists(CheckInAlreadyExistsException exception) {
//        return ResponseEntity.status(HttpStatus.CONFLICT).build();
//    }

    @ExceptionHandler(CheckInAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleCheckInAlreadyExists(CheckInAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponseDTO(exception.getMessage()));
    }

}
