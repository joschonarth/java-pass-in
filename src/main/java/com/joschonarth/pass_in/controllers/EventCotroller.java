package com.joschonarth.pass_in.controllers;

import com.joschonarth.pass_in.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventCotroller {

    private final EventService service;

    @GetMapping("/{id}")
    public ResponseEntity<String> getEvent(@PathVariable String id) {
        this.service.getEventDetail(id);
        return ResponseEntity.ok("Success!");
    }
}
