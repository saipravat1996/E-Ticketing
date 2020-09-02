package com.hexaphor.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hexaphor.Global.StaticData;
import com.hexaphor.model.Status;
import com.hexaphor.model.TrackerId;
import com.hexaphor.repo.StatusRepository;
import com.hexaphor.repo.TrackerIdRepository;

@Component
public class Command {

	@Autowired
	private TrackerIdRepository tracker_Id_Repository;
	@Autowired
	private StatusRepository status_Repository;
	List<Status> listStatus=StaticData.AllStatusDetails;
	
	public String createNewTrackerId(int trackid){
		TrackerId tracker_Id=null;
		String prifix=null;
		String[] filesize=null;
		String newID=null;
		
		try {
		//get TrackerId Table Data
		tracker_Id=tracker_Id_Repository.findById(trackid).get();
		
		//get PrefixID
		prifix=tracker_Id.getPrefix();
		
		//Split insertID using prefix value 
		filesize=tracker_Id.getLastIdInsert().split(prifix);
		
		//Get digit value
		String st=filesize[1];
		
		//Increase One value 
		Long filesizes=Long.parseLong(st)+1;
		
		//Differentiate the length
		int diff=st.length()-filesizes.toString().length();
		
		//add the last digit value 
		String s=st.substring(0, diff)+filesizes.toString();
		
		//concatited the string  
		newID=prifix+s;
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return newID;
	}
	
	//Updated Last Inserted TrackerID
	public void UpdatedTrackerID(int trackid,String insrtedID){
		tracker_Id_Repository.UpdatedTrackerID(insrtedID,trackid);
	}
	
	//get Status in string format
		public String getStatus(Integer id){
			
			String st=null;
			
			if(listStatus.size()==0){
				
				List<Status> list=	status_Repository.findAll();
				
				for (Status status : list) {
					
					if(status.getStatusID()==id){
						st=status.getStatus();
					}
				}
			}
			 return st;
		}
		
		
		    //get Status in Integer format
				public Integer getStatusID(String  StatusName){
					//List<Status> list=new ArrayList<Status>();
					Integer st=0;
					if(listStatus.size()==0){
						List<Status> list=	status_Repository.findAll();
						for (Status status : list) {
							if(status.getStatus().equals(StatusName.trim())){
								st=status.getStatusID();
							}
						}
					}
					
					 return st;
				}
}
