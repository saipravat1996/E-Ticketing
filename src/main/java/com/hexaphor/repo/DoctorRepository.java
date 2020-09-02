package com.hexaphor.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaphor.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
	
	@Query(value="select *  from Doctor_Reg v  where clinicID=?1",nativeQuery =true) 
    List<Doctor> getDoctorByClinicID(String clinicID);

}
