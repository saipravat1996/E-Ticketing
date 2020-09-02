package com.hexaphor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexaphor.model.TicketBooking;
import com.hexaphor.service.ITicketBookingService;

@RestController
public class TicketController {

	@Autowired
	private ITicketBookingService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> createTicket(@RequestBody TicketBooking ticketBooking){
		String id=service.saveBooking(ticketBooking);
		return null;
	}
	
}
