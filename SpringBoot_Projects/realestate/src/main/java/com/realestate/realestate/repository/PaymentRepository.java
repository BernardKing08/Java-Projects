package com.realestate.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.realestate.model.Payment;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
    Payment findByReference(String reference);
    
    List<Payment> findByPersonId(Long personId);
    
    List<Payment> findByStatus(String status);
}