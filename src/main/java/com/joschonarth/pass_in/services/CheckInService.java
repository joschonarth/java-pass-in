package com.joschonarth.pass_in.services;

import com.joschonarth.pass_in.domain.attendee.Attendee;
import com.joschonarth.pass_in.domain.checkin.CheckIn;
import com.joschonarth.pass_in.domain.checkin.exceptions.CheckInAlreadyExistsException;
import com.joschonarth.pass_in.domain.checkin.exceptions.CheckInNotFoundException;
import com.joschonarth.pass_in.repositories.CheckinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {

    private final CheckinRepository checkinRepository;

    public void registerCheckIn(Attendee attendee) {
        this.verifyCheckInExists(attendee.getId());

        CheckIn newCheckIn = new CheckIn();
        newCheckIn.setAttendee(attendee);
        newCheckIn.setCreatedAt(LocalDateTime.now());

        this.checkinRepository.save(newCheckIn);

    }

    private void verifyCheckInExists(String attendeeId) {
        Optional<CheckIn> isCheckedIn = this.getCheckIn(attendeeId);
        if (isCheckedIn.isPresent()) throw new CheckInAlreadyExistsException("Attendee already checked in");
    }

    public Optional<CheckIn> getCheckIn(String attendeeId) {
        return this.checkinRepository.findByAttendeeId(attendeeId);
    }

    public void cancelCheckIn(String attendeeId) {
        Optional<CheckIn> checkIn = this.getCheckIn(attendeeId);

        if (checkIn.isEmpty()) {
            throw new CheckInNotFoundException("Check-in not found for attendee with ID: " + attendeeId);
        }

        this.checkinRepository.delete(checkIn.get());
    }
}
