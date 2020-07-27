package com.hexaphor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaphor.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

}
