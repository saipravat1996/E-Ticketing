package com.hexaphor.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaphor.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {

}
