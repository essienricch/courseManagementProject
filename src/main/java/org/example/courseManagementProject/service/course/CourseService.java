package org.example.courseManagementProject.service.course;

import org.example.courseManagementProject.data.model.Course;
import org.example.courseManagementProject.dto.courseDto.request.CreateCourseRequest;
import org.example.courseManagementProject.dto.courseDto.response.CreateCourseResponse;
import org.example.courseManagementProject.exception.course.CourseDbException;

import java.util.List;

public interface CourseService {

    CreateCourseResponse createCourse(CreateCourseRequest createCourseRequest) throws CourseDbException;
    Course findCourseByName(String courseName);
    List<Course> findAllCourse();

}
