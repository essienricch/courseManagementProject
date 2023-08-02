package org.example.courseManagementProject.exception;

import org.example.courseManagementProject.exception.course.CourseException;
import org.example.courseManagementProject.exception.userexception.UserException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppCustomExceptionHandler {

    @ExceptionHandler(value = UserException.class)
    public ResponseEntity <ErrorObject> handleUserDbExceptions(Exception e, WebRequest request){
        ErrorObject errorObject = ErrorObject.builder()
                .webMessage(request.getDescription(false))
                                .date(new Date())
                .errorMessage(e.getMessage())
                                .build();
        return new ResponseEntity<>(errorObject, new HttpHeaders(),
                HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = CourseException.class)
    public ResponseEntity <ErrorObject> handleCourseDbExceptions(Exception e, WebRequest request){
        ErrorObject errorObject = ErrorObject.builder()
                .webMessage(request.getDescription(false))
                .date(new Date())
                .errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(errorObject, new HttpHeaders(),
                HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity <ErrorObject> handleAllExceptions(Exception e, WebRequest request){
        ErrorObject errorObject = ErrorObject.builder()
                .webMessage(request.getDescription(false))
                .date(new Date())
                .errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(errorObject, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
