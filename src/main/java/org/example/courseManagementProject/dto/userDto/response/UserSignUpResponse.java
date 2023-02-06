package org.example.courseManagementProject.dto.userDto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class UserSignUpResponse {

    private String username;
    private String message;
}
