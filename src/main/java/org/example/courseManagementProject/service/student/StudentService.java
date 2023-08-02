package org.example.courseManagementProject.service.student;

import org.example.courseManagementProject.data.dto.SignupDto;
import org.example.courseManagementProject.data.dto.StudentDto;
import org.example.courseManagementProject.data.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface StudentService {

    Map <String, String> registerNewStudent(SignupDto signupDto);
    StudentDto getStudentById(Long studentId);

   List<StudentDto> getAllStudent();

   Map <String, String> deleteStudent(Long studentId);
}
