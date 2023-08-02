package org.example.courseManagementProject.data.repository;

import org.example.courseManagementProject.data.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;




public interface CourseRepository extends JpaRepository<Course, Long> {
}
