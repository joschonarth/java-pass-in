package com.joschonarth.pass_in.repositories;

import com.joschonarth.pass_in.domain.checkin.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckinRepository extends JpaRepository<Checkin, Integer> {
}
