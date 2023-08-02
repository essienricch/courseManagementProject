package org.example.courseManagementProject.service.instructor;

import lombok.AllArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import org.example.courseManagementProject.data.model.Instructor;
import org.example.courseManagementProject.data.repository.InstructorRepository;
import org.example.courseManagementProject.exception.userexception.UserException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Slf4j
public class InstructorServiceImpl implements InstructorService{

    private final InstructorRepository instructorRepository;


    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor getInstructorById(Long instructorId) {
        checkIfInstructorExistsById(instructorId);
        return instructorRepository.getInstructorById(instructorId);
    }

    @Override
    public void checkIfInstructorExistsById(Long instructorId) {
        Optional <Instructor> instructor = instructorRepository.findById(instructorId);
        if (instructor.isEmpty())
            throw new UserException("Instructor Not found");
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }

    @Override
    public void deleteInstructor(Long instructorId) {
        checkIfInstructorExistsById(instructorId);
        instructorRepository.deleteById(instructorId);
    }
}
