package org.example.courseManagementProject.controller;

import org.example.courseManagementProject.data.model.Course;
import org.example.courseManagementProject.dto.courseDto.request.CreateCourseRequest;
import org.example.courseManagementProject.dto.courseDto.response.CreateCourseResponse;
import org.example.courseManagementProject.exception.course.CourseDbException;
import org.example.courseManagementProject.service.course.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private CourseServiceImpl courseService;

    @Autowired
    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCourseResponse> createCourse(@RequestBody CreateCourseRequest createCourseRequest) throws CourseDbException {
        return new ResponseEntity<>(courseService.createCourse(createCourseRequest), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity <List<Course>> getAllCourse(){
        List <Course> courses = courseService.findAllCourse();
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }
}
