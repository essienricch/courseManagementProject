package org.example.courseManagementProject.service.user;

import org.example.courseManagementProject.data.dto.userDto.request.UserSignUpRequest;
import org.example.courseManagementProject.data.dto.userDto.response.UserSignUpResponse;

public interface AppUserService {

    UserSignUpResponse registerInstructor(UserSignUpRequest signUpRequest);

    UserSignUpResponse registerStudent(UserSignUpRequest signUpRequest);
}
