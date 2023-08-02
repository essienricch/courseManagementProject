package org.example.courseManagementProject.service.student;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.courseManagementProject.data.dto.SignupDto;
import org.example.courseManagementProject.data.dto.StudentDto;
import org.example.courseManagementProject.data.model.AppUser;
import org.example.courseManagementProject.data.model.Role;
import org.example.courseManagementProject.data.model.Student;
import org.example.courseManagementProject.data.repository.StudentRepository;
import org.example.courseManagementProject.util.StudentUtils;
import org.example.courseManagementProject.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.example.courseManagementProject.util.AppUtilities.DISPLAY_PER_PAGES;

@Service
@AllArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentUtils studentUtils;

    @Autowired
    UserUtils userUtils;

    @Override
    public Map<String, String> registerNewStudent(SignupDto signupDto) {
        log.info("in the register new student service");
        Map <String, String> response = new HashMap<>();

        userUtils.validateSignUpDetails(signupDto);
        log.info("user sign up detail is valid");

        userUtils.validateUserEmail(signupDto.getEmail());
        log.info("email does not exist");

        AppUser user = userUtils.createAppUser(signupDto);
        user.setRoles(createStudentRole(Role.STUDENT));

       var savedUser = userUtils.saveUser(user);
        log.info("saved app user to db");

        Student student = new Student();
        student.setAppUser(savedUser);

        studentRepository.save(student);
        log.info("saved student to db");

        response.put("Detail: ", "Student Successfully Registered");
        return response;
    }

    private Set <Role> createStudentRole(Role role){
        Set <Role> studentRole = new HashSet<>();
        studentRole.add(role);
        return studentRole;
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        log.info("in the get student by id service");
        studentUtils.getStudentByIdIfExist(studentId);
        return new StudentDto();
    }

    @Override
    public List <StudentDto> getAllStudent() {
       List <StudentDto> studentDtos = new ArrayList<>();

        return studentDtos;
    }

    @Override
    public Map <String, String> deleteStudent(Long studentId) {

        studentRepository.deleteById(studentId);
        return null;
    }
}
