package com.hexaphor.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaphor.model.TicketBooking;

public interface TicketBookingRepository extends JpaRepository<TicketBooking, String> {

}
