package com.tuition.controller;

import com.tuition.model.ClassEntity;
import com.tuition.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
@CrossOrigin(origins = "*")
public class ClassController {

    @Autowired
    private ClassService service;

    @PostMapping
    public ClassEntity create(@RequestBody ClassEntity c) {
        return service.addClass(c);
    }

    @GetMapping("/student/{studentId}")
    public List<ClassEntity> getByStudent(@PathVariable Long studentId) {
        return service.getClassesByStudent(studentId);
    }
    
    @GetMapping("/tutor/{tutorId}")
    public List<ClassEntity> getByTutor(@PathVariable Long tutorId) {
        return service.getClassesByTutor(tutorId);
    }
    
    @PutMapping("/{id}")
    public ClassEntity update(@PathVariable Long id, @RequestBody ClassEntity updated) {
        return service.updateClass(id, updated);
    }

}






