package org.example.courseManagementProject.dto.userDto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignUpRequest {

    private String userName;
    private String emailAddress;
    private String password;


}
