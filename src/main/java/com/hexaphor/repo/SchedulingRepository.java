package com.hexaphor.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaphor.model.Scheduling;

public interface SchedulingRepository extends JpaRepository<Scheduling, String> {

	@Query("select s from Scheduling s where s.clinicId=:clinicId")
	Page<Scheduling> fineShcedulingByClinicId(String clinicId,Pageable pageable);
}
