package com.hexaphor.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hexaphor.Global.StaticData;
import com.hexaphor.common.Command;
import com.hexaphor.model.Scheduling;
import com.hexaphor.model.Status;
import com.hexaphor.repo.SchedulingRepository;
import com.hexaphor.service.ISchedulingService;

@Service
public class SchedulingServiceImpl implements ISchedulingService {

	@Autowired
	private SchedulingRepository scheduleRepo;
	/*
	 * @Autowired private SlotRepository slotRepo;
	 */
	
	
	List<Status> listStatus=StaticData.AllStatusDetails;
    @Autowired
	private Command code;
	//Create Scheduling 
	@Override
	public Scheduling saveScheduling(Scheduling scheduing) throws Exception {
		//Slot slot=null;
		//List<Slot> listSlots=new ArrayList<Slot>();
		
		/*
		 * for (Slot slot : listSlot) { //Create New SlotId
		 * slot.setSlotId(code.createNewTrackerId(10)); listSlots.add(slot); //Update
		 * SlotId code.UpdatedTrackerID(10, slot.getSlotId()); }
		 */
		
		//Save Slot
		//listSlot=slotRepo.saveAll(listSlots);
		
		//Create New ScheduingId
		scheduing.setSchedulingId(code.createNewTrackerId(13));
		
		//assign slot value in 
		//scheduing.setSlotMapping(listSlot);
		
		//Save scheduling
		scheduing=	scheduleRepo.save(scheduing);
		
		//Update Scheduling Id 
		code.UpdatedTrackerID(13, scheduing.getSchedulingId());
		
		return scheduing;
	}

	//Get All Scheduling
	@Override
	public Page<Scheduling> getPagingSchedulingByClinicId(Pageable pageable, String clinicId) throws Exception {

		//List<Scheduing> listSchedulings=scheduleRepo.findAll().stream().filter(st->st.getClinicId()==clinicId).collect(Collectors.toList());
		
		//Page<Scheduing> pageSchPage=scheduleRepo.fineShcedulingByClinicId(clinicId, pageable);
		 
		return scheduleRepo.fineShcedulingByClinicId(clinicId, pageable);
	}

	@Override
	public Scheduling updateScheling(Scheduling scheduing) throws Exception {
		
		/*
		 * List<Slot> listSlots=new ArrayList<Slot>(); List<Slot> removeSlot=new
		 * ArrayList<Slot>(); Scheduling
		 * scheduling=scheduleRepo.findById(scheduing.getSchedulingId()).get();
		 * 
		 * for (Slot slot1 : scheduling.getSlotMapping()) {
		 * 
		 * for (Slot slot : listSlot) { //If slot is available in updated slot then add
		 * otherwise remove slot if(slot1.getSlotId()==slot.getSlotId()) {
		 * listSlots.add(slot1); } else { removeSlot.add(slot); } } }
		 */
		
		/*
		 * //Remove Slot slotRepo.deleteInBatch(removeSlot); //Save Slot
		 * listSlots=slotRepo.saveAll(listSlots);
		 * 
		 * //Set slot in scheduling scheduing.setSlotMapping(listSlots);
		 */
		
		
		
		//Save Scheduling
		scheduing=	scheduleRepo.save(scheduing);
		
		return scheduing;
	}

	@Override
	public Scheduling getSchedulingBySchedulingId(String schdulingId) throws Exception {
		//Get Scheduling By ID
		return scheduleRepo.findById(schdulingId).get();
	}

	@Override
	public List<Scheduling> getAllSchedulingByClinicId(String clinicId) throws Exception {
		
		//Use Stream API to process data
		return scheduleRepo.findAll().stream().filter(st->st.getClinicId()==clinicId).collect(Collectors.toList());
	}

	@Override
	public String removeSchedulingById(String schdulingId) throws Exception {
		String response ="fail"; 
		if(scheduleRepo.existsById(schdulingId)) {
		scheduleRepo.deleteById(schdulingId);
		response="success";
		}
		return response;
	}

}
