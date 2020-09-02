package com.hexaphor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaphor.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

	@Query("select statusID from Status where status=:status")
	public Integer getStatucByStatus_Name(String status);
}
