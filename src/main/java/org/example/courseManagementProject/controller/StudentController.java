package org.example.courseManagementProject.controller;

import lombok.AllArgsConstructor;
import org.example.courseManagementProject.data.dto.SignupDto;
import org.example.courseManagementProject.data.model.Student;
import org.example.courseManagementProject.service.student.StudentService;
import org.example.courseManagementProject.service.student.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/student")
@AllArgsConstructor
@RestController
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;


    @PostMapping("/register")
    public ResponseEntity <?> registerStudent(@RequestBody SignupDto signupDto){
        return new ResponseEntity<>(studentService.registerNewStudent(signupDto), HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity <?> getStudentById(@PathVariable Long studentId){
        return ResponseEntity.status(200).body(studentService.getStudentById(studentId));

    }

    @GetMapping("/all")
    public ResponseEntity <?> getAllStudent(){
      return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity <?> deleteStudentById(@PathVariable Long studentId){
        return new ResponseEntity<>(studentService.deleteStudent(studentId), HttpStatus.OK);
    }
}
