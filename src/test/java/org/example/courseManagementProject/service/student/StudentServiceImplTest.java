package org.example.courseManagementProject.service.student;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.courseManagementProject.data.model.AppUser;
import org.example.courseManagementProject.data.model.Gender;
import org.example.courseManagementProject.data.model.Role;
import org.example.courseManagementProject.data.model.Student;
import org.example.courseManagementProject.data.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveStudent_successTest(){
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        appUser.setFirstName("Jonjo");
        appUser.setLastName("Shelvey");
        appUser.setEmailAddress("shelvey@hotmail.com");
        appUser.setRoles(Set.of(Role.STUDENT));
        appUser.setGender(Gender.MALE);

        Student student = new Student();
        student.setAppUser(appUser);
        student.setId(1L);
        when(studentRepository.save(student)).thenReturn(student);
       Student savedStudent = studentService.saveStudent(student);
       verify(studentRepository, times(1)).save(student);

       assertEquals(savedStudent, student);
    }

    @Test
    void getStudentById_successTest(){
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        appUser.setFirstName("Jonjo");
        appUser.setLastName("Shelvey");
        appUser.setEmailAddress("shelvey@hotmail.com");
        appUser.setRoles(Set.of(Role.STUDENT));
        appUser.setGender(Gender.MALE);

        Student student = new Student();
        student.setAppUser(appUser);
        student.setId(1L);
        when(studentRepository.save(student)).thenReturn(student);
        when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
        when(studentRepository.getStudentById(student.getId())).thenReturn(student);
        studentService.saveStudent(student);
        var savedStudent = studentService.getStudentById(1L);
        verify(studentRepository, times(1)).save(student);
        verify(studentRepository, times(1)).getStudentById(student.getId());
        assertEquals(savedStudent, student);
    }

}