package com.tuition.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ✅ auto generate id!
    private Long id;

    private String subject;
    private String day;
    private String startTime;
    private String endTime;
    private String status;
    private Long tutorId;

    @ElementCollection
    private List<Long> studentIds;

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getTutorId() { return tutorId; }
    public void setTutorId(Long tutorId) { this.tutorId = tutorId; }

    public List<Long> getStudentIds() { return studentIds; }
    public void setStudentIds(List<Long> studentIds) { this.studentIds = studentIds; }
}

