package org.example.courseManagementProject.dto.courseDto.request;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CreateCourseRequest {

    private String courseName;
    private int numberOfStudent;
}
