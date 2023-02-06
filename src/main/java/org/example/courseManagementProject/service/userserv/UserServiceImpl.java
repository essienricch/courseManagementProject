package org.example.courseManagementProject.service.userserv;

import org.example.courseManagementProject.data.model.Role;
import org.example.courseManagementProject.data.model.User_Entity;
import org.example.courseManagementProject.data.repository.RoleRepository;
import org.example.courseManagementProject.data.repository.UserRepository;
import org.example.courseManagementProject.dto.userDto.request.AdminLoginRequest;
import org.example.courseManagementProject.dto.userDto.request.CreateRoleRequest;
import org.example.courseManagementProject.dto.userDto.request.UserLoginRequest;
import org.example.courseManagementProject.dto.userDto.request.UserSignUpRequest;
import org.example.courseManagementProject.dto.userDto.response.AdminLoginResponse;
import org.example.courseManagementProject.dto.userDto.response.CreateRoleResponse;
import org.example.courseManagementProject.dto.userDto.response.UserLoginResponse;
import org.example.courseManagementProject.dto.userDto.response.UserSignUpResponse;
import org.example.courseManagementProject.exception.userexception.UserDbException;
import org.example.courseManagementProject.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private SecurityConfig config;
    private AuthenticationManager manager;

    @Autowired
    public UserServiceImpl(UserRepository userRepository
            ,RoleRepository roleRepository
            ,SecurityConfig config
            ,AuthenticationManager manager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.config = config;
        this.manager = manager;
    }

    @Override
    public UserSignUpResponse signUpUser(UserSignUpRequest signUpRequest) throws UserDbException {

        User_Entity userEntity = userRepository.findUser_EntityByUserName(signUpRequest.getUserName());
        if (!userRepository.existsByEmailAddress(signUpRequest.getEmailAddress()) && userEntity == null){
            userEntity.setUserName(signUpRequest.getUserName());
            userEntity.setEmailAddress(signUpRequest.getEmailAddress());
            userEntity.setPassword(config.passwordEncoder().encode(signUpRequest.getPassword()));
            Role savedRole = roleRepository.findRoleByRoleName("user");
            userEntity.setRoles(List.of(savedRole));
            User_Entity savedUserEntity = userRepository.save(userEntity);
            //            signUpResponse.setUsername(savedUserEntity.getUserName());
//            signUpResponse.setMessage(savedUserEntity.getUserName() + "Successfully Sign-up");
            return new UserSignUpResponse(savedUserEntity.getUserName()
                    ,"Sign-up Successfully");
        }else throw new UserDbException("User already exists");
    }


    @Override
    public UserLoginResponse loginUser(UserLoginRequest userLoginRequest) {
        return null;
    }

    @Override
    public CreateRoleResponse signUpAdmin(CreateRoleRequest createRoleRequest) {
        return null;
    }

    @Override
    public AdminLoginResponse loginAdmin(AdminLoginRequest adminLoginRequest) {
        return null;
    }

    @Override
    public User_Entity findUser(String userName) throws UserDbException {
        User_Entity savedUser = userRepository.findUser_EntityByUserName(userName);
        if (savedUser == null){
            throw new UserDbException("User not found");
        }else return savedUser;
    }

    @Override
    public List<User_Entity> findAllUsers() {
        return null;
    }
}
