package com.tuition.service;

import com.tuition.model.Payment;
import com.tuition.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    public Payment addPayment(Payment payment) {
        payment.setCreatedDate(LocalDateTime.now());
        return paymentRepo.save(payment);
    }

    public List<Payment> getPaymentsForStudent(Long studentId) {
        return paymentRepo.findByStudentId(studentId);
    }
}





