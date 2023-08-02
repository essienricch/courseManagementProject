package org.example.courseManagementProject.security;


import lombok.AllArgsConstructor;
import org.example.courseManagementProject.data.model.AppUser;
import org.example.courseManagementProject.data.model.Role;
import org.example.courseManagementProject.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserCustomServiceSecurity {

    private final UserRepository userRepository;


//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//      Optional <AppUser> userEntity = userRepository.findAppUserById(email);
//      return null;
////      if (userEntity.isPresent()){
////          return new User(userEntity.get().getEmailAddress(), userEntity.get().getPassword(), userEntity);
////
////        }
//    }
//
//    private Collection <GrantedAuthority> mapRolesToAuthority(Role roles){
//        return null;
////        return roles.getClass().getSimpleName();
////                .stream().map((r) -> new SimpleGrantedAuthority(r.getRoleName())).collect(Collectors.toList());
//    }
}
