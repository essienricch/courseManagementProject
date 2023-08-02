package org.example.courseManagementProject.data.repository;

import org.example.courseManagementProject.data.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository <Instructor, Long> {
    Instructor getInstructorById(Long instructorId);
}
