package org.example.courseManagementProject.data.dto.userDto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@Builder
public class UserSignUpResponse {
    private int userId;
    private String username;
    private String message;
    private int statusCode;
}
