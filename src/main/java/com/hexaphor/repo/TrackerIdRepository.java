package com.hexaphor.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaphor.model.TrackerId;
@Repository
public interface TrackerIdRepository extends JpaRepository<TrackerId, Integer> {

	@Modifying
	@Transactional
	@Query("update  TrackerId t set t.lastIdInsert=:lastIdInsert where t.trackerId=:trackerId")
	public Integer UpdatedTrackerID(String lastIdInsert,Integer trackerId);
}
