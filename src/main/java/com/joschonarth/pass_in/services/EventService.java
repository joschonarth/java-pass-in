package com.joschonarth.pass_in.services;

import com.joschonarth.pass_in.domain.attendee.Attendee;
import com.joschonarth.pass_in.domain.event.Event;
import com.joschonarth.pass_in.dto.event.EventResponseDTO;
import com.joschonarth.pass_in.repositories.AttendeeRepository;
import com.joschonarth.pass_in.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public EventResponseDTO getEventDetail(String eventId) {
        Event event = this.eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found with ID: " + eventId));
        List<Attendee> attendeeList = this.attendeeRepository.findByEventId(eventId);
        return new EventResponseDTO(event, attendeeList.size());
    }
}
