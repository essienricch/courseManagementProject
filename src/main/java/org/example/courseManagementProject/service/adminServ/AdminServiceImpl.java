package org.example.courseManagementProject.service.adminServ;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.example.courseManagementProject.data.repository.AdminRepository;
import org.example.courseManagementProject.data.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
@Slf4j
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

//    @Override
//    public UserSignUpResponse signUpAdmin(UserSignUpRequest userSignUpRequest) throws UserDbException {
//
//            if (!userRepository.existsByEmail(userSignUpRequest.getEmailAddress())){
//               var userEntity = MainMapper.mapToUserEntity(userSignUpRequest);
//
//                Role role = roleRepository.findRoleByRoleName("ADMIN");
//                userEntity.setRoles(Set.of(role));
//                userEntity.setCreatedAt(LocalDateTime.now());
//
//                var admin = new Admin();
//                admin.setUser(userEntity);
//
//                var saveAdmin = adminRepository.save(admin);
//                return MainMapper.adminMapToRegisterResponse(saveAdmin);
//            }else throw new UserDbException("User already exists in the DB");
//
//    }

//    @Override
//    public AdminLoginResponse loginAdmin(AdminLoginRequest adminLoginRequest) {
//        return null;
//    }

}
