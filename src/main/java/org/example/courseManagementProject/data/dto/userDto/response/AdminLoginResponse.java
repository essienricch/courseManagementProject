package org.example.courseManagementProject.data.dto.userDto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminLoginResponse {
    private String message;
    private String userName;
}
