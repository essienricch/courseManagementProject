package org.example.courseManagementProject.data.dto.userDto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminLoginRequest {
    private String userName;
    private String password;
}
