package org.example.courseManagementProject.service.userserv;

import org.example.courseManagementProject.data.model.User_Entity;
import org.example.courseManagementProject.dto.userDto.request.AdminLoginRequest;
import org.example.courseManagementProject.dto.userDto.request.CreateRoleRequest;
import org.example.courseManagementProject.dto.userDto.request.UserLoginRequest;
import org.example.courseManagementProject.dto.userDto.request.UserSignUpRequest;
import org.example.courseManagementProject.dto.userDto.response.AdminLoginResponse;
import org.example.courseManagementProject.dto.userDto.response.CreateRoleResponse;
import org.example.courseManagementProject.dto.userDto.response.UserLoginResponse;
import org.example.courseManagementProject.dto.userDto.response.UserSignUpResponse;
import org.example.courseManagementProject.exception.userexception.UserDbException;

import java.util.List;

public interface UserService {

    UserSignUpResponse signUpUser(UserSignUpRequest userSignUpRequest) throws UserDbException;
    UserLoginResponse loginUser(UserLoginRequest userLoginRequest);

    CreateRoleResponse signUpAdmin(CreateRoleRequest createRoleRequest);

    AdminLoginResponse loginAdmin(AdminLoginRequest adminLoginRequest);

    User_Entity findUser(String userName) throws UserDbException;

    List <User_Entity> findAllUsers();

}
