package org.example.courseManagementProject.util;

import lombok.extern.slf4j.Slf4j;
import org.example.courseManagementProject.data.dto.SignupDto;
import org.example.courseManagementProject.data.model.AppUser;
import org.example.courseManagementProject.data.repository.UserRepository;
import org.example.courseManagementProject.exception.userexception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserUtils {
    @Autowired
    UserRepository userRepository;

    public UserException userNotFoundException(String exception){
        return new UserException(exception);
    }

    public UserException userAlreadyExistException(String exception){
        return new UserException(exception);
    }

    public UserException illegalArgumentException(String exception){
        return new UserException(exception);
    }

    public void validateSignUpDetails(SignupDto signupDto){
        log.info("in the validate sign up detail: ");
        if (signupDto.getUsername().isBlank() || signupDto.getUsername().isEmpty()){
            throw illegalArgumentException("username can not be empty ");
        }
        if (signupDto.getEmail().isBlank() || signupDto.getEmail().isEmpty()){
            throw illegalArgumentException("email can not be empty");
        }
        if (signupDto.getPassword().isBlank() || signupDto.getPassword().isEmpty()){
            throw illegalArgumentException("password can not be empty");
        }
        if (signupDto.getPhoneNumber().isBlank() || signupDto.getPhoneNumber().isEmpty()){
            throw illegalArgumentException("phone-number can not be empty");
        }
    }

    public void validateUserEmail(String email){
        Boolean userExist = userRepository.existsByEmail(email);
        if (userExist){
            throw userAlreadyExistException(String.format("App User with email %s already exist",email));
        }
    }

    public void checkIfUserExistByEmail(String email){
        Optional < AppUser> user = Optional.ofNullable(userRepository.getAppUserByEmail(email));
        if (user.isEmpty()){
            throw userNotFoundException(String.format("User with email %s not found",email));
        }
    }

    public AppUser getAppUserByEmailIfExists(String email){
        checkIfUserExistByEmail(email);
        return userRepository.getAppUserByEmail(email);
    }

    public AppUser createAppUser(SignupDto signupDto){
        log.info("in the create new app user service");
        AppUser user = new AppUser();
        user.setUsername(signupDto.getUsername());
        user.setEmail(signupDto.getEmail());
        user.setPhoneNumber(signupDto.getPhoneNumber());
        user.setPassword(signupDto.getPassword());
        return user;
    }

    public AppUser saveUser(AppUser user){
        return userRepository.save(user);
    }
}
