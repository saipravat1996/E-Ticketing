package com.hexaphor.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaphor.model.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, String> {

	@Query("select d from Disease d where d.clinicId=:clinicId")
	Page<Disease> findDiseaseByClinicId(String clinicId,Pageable Pageable);
}
