package org.example.courseManagementProject.util;

import lombok.extern.slf4j.Slf4j;
import org.example.courseManagementProject.data.model.Student;
import org.example.courseManagementProject.data.repository.StudentRepository;
import org.example.courseManagementProject.exception.student.StudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class StudentUtils {

    @Autowired
    StudentRepository studentRepository;

    public StudentException studentAlreadyExists(String exception){
        return new  StudentException(exception);
    }

    public StudentException studentNotFoundException(String exception){
        return new  StudentException(exception);
    }

    public StudentException illegalArgumentException(String exception){
        return new  StudentException(exception);
    }

    public void checkIfStudentExistById(Long studentId){
        Optional <Student> student = studentRepository.findById(studentId);
        if (student.isEmpty()){
            throw studentNotFoundException(String.format("Student with id %d not found",studentId));
        }
    }

    public Student getStudentByIdIfExist(Long studentId){
        checkIfStudentExistById(studentId);
        return studentRepository.getStudentById(studentId);
    }
}
