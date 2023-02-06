package org.example.courseManagementProject.security;


import org.example.courseManagementProject.data.model.Role;
import org.example.courseManagementProject.data.model.User_Entity;
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
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCustomServiceSecurity  implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserCustomServiceSecurity(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User_Entity userEntity = userRepository.findUser_EntityByUserName(username);
        return new User(userEntity.getUserName(), userEntity.getPassword(), mapRolesToAuthority(userEntity.getRoles()));
    }

    private Collection <GrantedAuthority> mapRolesToAuthority(List <Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
