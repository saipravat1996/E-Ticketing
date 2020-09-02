package com.hexaphor.service;

import java.util.List;

import com.hexaphor.model.TicketBooking;

public interface ITicketBookingService {

	
	public String saveBooking(TicketBooking ticketBooking);
	
	public String updateBooking(TicketBooking ticketBooking);
	
	public TicketBooking getTicketBookingById(String ticketId);
	
	public List<TicketBooking> getAllTicketByClinicId(String clinicId);
	
	public void removeTicket(String ticketId);
	
	
}
