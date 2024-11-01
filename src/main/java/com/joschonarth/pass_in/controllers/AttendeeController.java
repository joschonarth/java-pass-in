package com.joschonarth.pass_in.controllers;

import com.joschonarth.pass_in.dto.attendee.AttendeeBadgeResponseDTO;
import com.joschonarth.pass_in.services.AttendeeService;
import com.joschonarth.pass_in.services.CheckInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/attendees")
@RequiredArgsConstructor
public class AttendeeController {

    private final AttendeeService attendeeService;
    private final CheckInService checkInService;

    @GetMapping("/{attendeeId}/badge")
    public ResponseEntity<AttendeeBadgeResponseDTO> getAttendeeBadge(@PathVariable String attendeeId, UriComponentsBuilder uriComponentsBuilder) {
        AttendeeBadgeResponseDTO response = this.attendeeService.getAttendeeBadge(attendeeId, uriComponentsBuilder);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{attendeeId}/check-in")
    public ResponseEntity<Void> registerCheckIn(@PathVariable String attendeeId, UriComponentsBuilder uriComponentsBuilder) {
        this.attendeeService.checkInAttendee(attendeeId);

        var uri = uriComponentsBuilder.path("/attendees/{attendeeId}/badge").buildAndExpand(attendeeId).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{attendeeId}/check-in")
    public ResponseEntity<String> cancelCheckIn(@PathVariable String attendeeId) {
        checkInService.cancelCheckIn(attendeeId);
        return ResponseEntity.ok("Check-in cancelado com sucesso!");
    }
}
