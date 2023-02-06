package org.example.courseManagementProject.service.userserv;

import org.example.courseManagementProject.dto.userDto.request.UserSignUpRequest;
import org.example.courseManagementProject.dto.userDto.response.UserSignUpResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void createUserSignUpTest(){
        try{
        UserSignUpRequest signUpRequest = new UserSignUpRequest("Asake",
                "asake_ybnlmafia@yahoo.com","yoga2023");
            UserSignUpResponse   signUpResponse = userService.signUpUser(signUpRequest);
            //assertEquals("Asake", signUpResponse.getUsername());
            System.out.println(signUpResponse.getUsername());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}