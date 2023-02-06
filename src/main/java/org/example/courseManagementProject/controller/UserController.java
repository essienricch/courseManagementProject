package org.example.courseManagementProject.controller;

import org.example.courseManagementProject.dto.userDto.request.UserSignUpRequest;
import org.example.courseManagementProject.dto.userDto.response.UserSignUpResponse;
import org.example.courseManagementProject.exception.userexception.UserDbException;
import org.example.courseManagementProject.service.userserv.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public ResponseEntity <UserSignUpResponse> userSignUp(@RequestBody UserSignUpRequest userSignUpRequest) throws UserDbException {
        return new ResponseEntity<>(userService.signUpUser(userSignUpRequest), new HttpHeaders(), HttpStatus.CREATED);
    }
}
