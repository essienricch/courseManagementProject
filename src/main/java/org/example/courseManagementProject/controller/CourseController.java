package org.example.courseManagementProject.controller;

import lombok.AllArgsConstructor;
import org.example.courseManagementProject.service.course.CourseServiceImpl;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseServiceImpl courseService;


//
//    @PostMapping("/create")
//    public ResponseEntity<CreateCourseResponse> createCourse(@RequestBody CreateCourseRequest createCourseRequest) throws CourseException {
//        return new ResponseEntity<>(courseService.createCourse(createCourseRequest), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/")
//    public ResponseEntity <List<CourseDtoView>> getAllCourse(){
//        var courses = courseService.findAllCourse();
//        return ResponseEntity.status(HttpStatus.OK.value()).body(courses);
//    }
}
