package com.joschonarth.pass_in.controllers;

import com.joschonarth.pass_in.dto.attendee.AttendeesListResponseDTO;
import com.joschonarth.pass_in.dto.event.EventIdDTO;
import com.joschonarth.pass_in.dto.event.EventRequestDTO;
import com.joschonarth.pass_in.dto.event.EventResponseDTO;
import com.joschonarth.pass_in.services.AttendeeService;
import com.joschonarth.pass_in.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventCotroller {

    private final EventService eventService;

    private final AttendeeService attendeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEvent(@PathVariable String id) {
        EventResponseDTO event = this.eventService.getEventDetail(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventIdDTO> createEvent(@RequestBody EventRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        EventIdDTO eventIdDTO = this.eventService.createEvent(body);

        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(eventIdDTO.eventId()).toUri();

        return ResponseEntity.created(uri).body(eventIdDTO);
    }

    @GetMapping("/attendees/{id}")
    public ResponseEntity<AttendeesListResponseDTO> getEventAttendees(@PathVariable String id) {
        AttendeesListResponseDTO attendeesListResponse = this.attendeeService.getEventsAttendee(id);
        return ResponseEntity.ok(attendeesListResponse);
    }
}
