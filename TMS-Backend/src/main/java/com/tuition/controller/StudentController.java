package com.tuition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tuition.repository.*;
import com.tuition.model.*;
import com.tuition.service.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired private ClassRepository classRepo;
    @Autowired private PaymentRepository paymentRepo;
    @Autowired private UserService userService;  // ✅ added

    @GetMapping("/{studentId}/classes")
    public List<ClassEntity> getStudentClasses(@PathVariable Long studentId) {
        return classRepo.findAll().stream()
            .filter(c -> c.getStudentIds() != null && c.getStudentIds().contains(studentId))
            .collect(Collectors.toList());
    }

    @GetMapping("/{studentId}/payments")
    public List<Payment> getPayments(@PathVariable Long studentId) {
        return paymentRepo.findByStudentId(studentId);
    }

    @PostMapping("/{studentId}/addClass")
    public ClassEntity addClass(@PathVariable Long studentId, @RequestBody Map<String, String> data) {
        String subject = data.get("subject");
        ClassEntity c = new ClassEntity();
        c.setSubject(subject);
        c.setStatus("Scheduled");
        c.setDay("Pending");
        c.setStartTime("00:00");
        c.setEndTime("00:00");
        c.setStudentIds(Arrays.asList(studentId));
        return classRepo.save(c);
    }

    @GetMapping("/all")  // better to avoid conflict with other GETs
    public List<User> getAllStudents() {
        return userService.getAllStudents();
    }
}

