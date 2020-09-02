package com.hexaphor.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaphor.model.Slot;

public interface SlotRepository extends JpaRepository<Slot, Integer> {

}
