package org.example.courseManagementProject.service.instructor;

import org.example.courseManagementProject.data.model.Instructor;

import java.util.List;

public interface InstructorService {



    Instructor saveInstructor(Instructor instructor);

    Instructor getInstructorById(Long instructorId);

    void checkIfInstructorExistsById(Long instructorId);


    List <Instructor> getAllInstructor();

    void deleteInstructor(Long instructorId);

}
