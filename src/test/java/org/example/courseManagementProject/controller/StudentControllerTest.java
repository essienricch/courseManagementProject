package org.example.courseManagementProject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.courseManagementProject.data.model.AppUser;
import org.example.courseManagementProject.data.model.Course;
import org.example.courseManagementProject.data.model.Gender;
import org.example.courseManagementProject.data.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAStudentById_successTest() throws Exception {
        AppUser appUser = new AppUser();
        appUser.setGender(Gender.MALE);
        appUser.setEmailAddress("seyi-vybez@yahoo.com");
        appUser.setFirstName("Seyi");
        appUser.setLastName("Vibez");
        appUser.setPassword("20345");

        Course course = new Course();
        course.setDuration(3);
        course.setDescription("Musicals");
        course.setTitle("Seminar on Music");

        Set < Course> courses = new HashSet<>(Set.of(course));

        Student student = new Student();
        student.setAppUser(appUser);
        student.setCourses(courses);
        student.setEnrollmentDate(LocalDate.now());

        String studentObject = objectMapper.writeValueAsString(student);

        mockMvc.perform(MockMvcRequestBuilders.post("api/student/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentObject))
                .andExpect((ResultMatcher) status(HttpStatus.CREATED))
                .andDo(print());


    }

}