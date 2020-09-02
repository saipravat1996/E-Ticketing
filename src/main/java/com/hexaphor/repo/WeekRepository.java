package com.hexaphor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaphor.model.Week;

@Repository
public interface WeekRepository extends JpaRepository<Week,Integer> {

}
