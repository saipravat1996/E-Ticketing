package com.hexaphor.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaphor.common.Command;
import com.hexaphor.model.TicketBooking;
import com.hexaphor.repo.TicketBookingRepository;
import com.hexaphor.service.ITicketBookingService;

@Service
public class TicketBookingServiceImpl implements ITicketBookingService {

	@Autowired
	private TicketBookingRepository repo;
	
	@Autowired
	private Command code;
	
	@Override
	public String saveBooking(TicketBooking ticketBooking) {
		ticketBooking.setTicketId(code.createNewTrackerId(14));
		String tkId=repo.save(ticketBooking).getTicketId();
		code.UpdatedTrackerID(14, tkId);
		return tkId;
	}

	@Override
	public String updateBooking(TicketBooking ticketBooking) {
		
		return repo.save(ticketBooking).getTicketId();
	}

	@Override
	public TicketBooking getTicketBookingById(String ticketId) {
		
		return repo.findById(ticketId).get();
	}

	@Override
	public List<TicketBooking> getAllTicketByClinicId(String clinicId) {
		List<TicketBooking> list=repo.findAll();
		return list.stream().filter(cl->cl.getClinicId()==clinicId).collect(Collectors.toList());
	}

	@Override
	public void removeTicket(String ticketId) {
		if(repo.existsById(ticketId)) {
			repo.deleteById(ticketId);
		}

	}

}
