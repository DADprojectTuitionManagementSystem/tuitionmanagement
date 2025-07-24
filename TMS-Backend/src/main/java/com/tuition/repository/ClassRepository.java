package com.tuition.repository;

import com.tuition.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    List<ClassEntity> findByStudentIdsContains(Long studentId);
    List<ClassEntity> findByTutorId(Long tutorId);
}


