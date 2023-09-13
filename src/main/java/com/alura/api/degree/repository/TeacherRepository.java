package com.alura.api.degree.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.api.degree.model.teacher.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    public Page<Teacher> findAllByActiveTrue(Pageable pageable);
    
}