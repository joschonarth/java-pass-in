package com.joschonarth.pass_in.repositories;

import com.joschonarth.pass_in.domain.attendee.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeerRepository extends JpaRepository<Attendee, String> {
}
