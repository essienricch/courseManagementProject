package org.example.courseManagementProject.service.course;

import org.example.courseManagementProject.data.model.Course;
import org.example.courseManagementProject.data.repository.CourseRepository;
import org.example.courseManagementProject.data.repository.TopicRepository;
import org.example.courseManagementProject.dto.courseDto.request.CourseDtoView;
import org.example.courseManagementProject.dto.courseDto.request.CreateCourseRequest;
import org.example.courseManagementProject.dto.courseDto.response.CreateCourseResponse;
import org.example.courseManagementProject.exception.course.CourseDbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;
    private TopicRepository topicRepository;


    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, TopicRepository topicRepository) {
        this.courseRepository = courseRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    public CreateCourseResponse createCourse(CreateCourseRequest createCourseRequest) throws CourseDbException {
        CreateCourseResponse courseResponse = new CreateCourseResponse();
        Course course = courseRepository.findCourseByCourseName(createCourseRequest.getCourseName());
        if (course == null){
            Course newCourse = new Course();
            newCourse.setCourseName(createCourseRequest.getCourseName());
            newCourse.setNumberOfStudent(createCourseRequest.getNumberOfStudent());
            Course savedCourse = courseRepository.save(newCourse);
            courseResponse.setCourseId(savedCourse.getCourseId());
            courseResponse.setMessage(savedCourse.getCourseName() + "Successfully created");
            return courseResponse;
        }else throw new CourseDbException("Course Name already exist");
    }

    @Override
    public Course findCourseByName(String courseName) {
        return null;
    }

    @Override
    public List<Course> findAllCourse() {
        List <Course> courses = courseRepository.findAll();
        return courses.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private Course mapToDto(Course c) {
        CourseDtoView courseDtoView = new CourseDtoView();
        courseDtoView.setCourseId(c.getCourseId());
        courseDtoView.setCourseName(c.getCourseName());
        courseDtoView.setNumberOfStudent(c.getNumberOfStudent());
        return new Course(courseDtoView.getCourseId(), courseDtoView.getCourseName(), courseDtoView.getNumberOfStudent());
    }


}
