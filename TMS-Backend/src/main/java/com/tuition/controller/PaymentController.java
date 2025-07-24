package com.tuition.controller;

import com.tuition.model.Payment;
import com.tuition.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment create(@RequestBody Payment payment) {
        return paymentService.addPayment(payment);
    }

    @GetMapping("/student/{studentId}")
    public List<Payment> getByStudent(@PathVariable Long studentId) {
        return paymentService.getPaymentsForStudent(studentId);
    }
}









