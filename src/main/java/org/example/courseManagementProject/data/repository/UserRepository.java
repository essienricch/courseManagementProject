package org.example.courseManagementProject.data.repository;

import org.example.courseManagementProject.data.model.User_Entity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository <User_Entity, Integer> {

    User_Entity findUser_EntityByUserName(String userName);
    boolean existsByEmailAddress(String emailAddress);
}
