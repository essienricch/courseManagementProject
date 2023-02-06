package org.example.courseManagementProject.exception;


import lombok.*;
import java.util.Date;

@Builder
@Getter
@Setter
public class ErrorObject {

    private final String webMessage;
    private final Date date;
    private final String errorMessage;

}
