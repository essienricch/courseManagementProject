package org.example.courseManagementProject.service.course;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.courseManagementProject.data.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;




//    @Override
//    public CreateCourseResponse createCourse(CreateCourseRequest createCourseRequest) throws CourseException {
//        CreateCourseResponse courseResponse = new CreateCourseResponse();
//        var course = courseRepository.findCourseByCourseName(createCourseRequest.getCourseName());
//        if (course.isEmpty()){
//            Course newCourse = new Course();
//            newCourse.setCourseName(createCourseRequest.getCourseName());
//            Course savedCourse = courseRepository.save(newCourse);
//            courseResponse.setCourseId(savedCourse.getCourseId());
//            courseResponse.setMessage(savedCourse.getCourseName() + "Successfully created");
//            return courseResponse;
//        }else throw new CourseException("Course Name already exist");
//    }
//
//    @Override
//    public Course findCourseByName(String courseName) {
//        return null;
//    }
//
//    @Override
//    public List <CourseDtoView> findAllCourse() {
//        return  courseRepository.findAll().stream().map(course -> mapToDto(course)).collect(Collectors.toList());
//    }
//
//    private CourseDtoView mapToDto(Course c) {
//        CourseDtoView courseDtoView = new CourseDtoView();
//        courseDtoView.setCourseId(c.getCourseId());
//        courseDtoView.setCourseName(c.getCourseName());
//        courseDtoView.setTopics(c.getTopics());
//
//        return courseDtoView;
//    }


}
