package com.realestate.realestate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.realestate.model.Payment;
import com.realestate.realestate.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository paymentRepository;
    
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
    
    public Payment findByReference(String reference) {
        return paymentRepository.findByReference(reference);
    }
    
    public List<Payment> findByPersonId(Long personId) {
        return paymentRepository.findByPersonId(personId);
    }
    
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }
}