package org.example.courseManagementProject.data.repository;

import org.example.courseManagementProject.data.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {

    Student getStudentById(Long studentId);
}
