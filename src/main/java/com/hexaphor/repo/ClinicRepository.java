package com.hexaphor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaphor.model.Clinic;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, String> {
	
	@Query("select count(gmailID) from Clinic where gmailID=:gmailID")
	Integer countGmailEmailId(String gmailID);
	
	@Query("select count(phoneNumber) from Clinic where phoneNumber=:phoneNumber")
	Integer countClientPhoneNumber(Long phoneNumber);
	
	@Query("select count(phoneNumber) from Clinic where clinicName=:clinicName")
	Integer countClientName(String clinicName);

}
