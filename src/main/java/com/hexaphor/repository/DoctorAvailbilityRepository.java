package com.hexaphor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaphor.model.DoctorAvailbility;

@Repository
public interface DoctorAvailbilityRepository extends JpaRepository<DoctorAvailbility, String> {

}
