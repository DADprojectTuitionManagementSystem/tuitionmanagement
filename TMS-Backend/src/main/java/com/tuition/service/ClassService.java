package com.tuition.service;

import com.tuition.model.ClassEntity;
import com.tuition.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository repo;

    public ClassEntity addClass(ClassEntity c) {
        return repo.save(c);
    }

    public List<ClassEntity> getClassesByStudent(Long studentId) {
        return repo.findByStudentIdsContains(studentId);
    }
    
    public List<ClassEntity> getClassesByTutor(Long tutorId) {
        return repo.findByTutorId(tutorId);
    }
    
    public ClassEntity updateClass(Long id, ClassEntity updated) {
        ClassEntity existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Class not found"));

        existing.setDay(updated.getDay());
        existing.setStartTime(updated.getStartTime());
        existing.setEndTime(updated.getEndTime());
        existing.setStatus(updated.getStatus());

        return repo.save(existing);
    }


}



