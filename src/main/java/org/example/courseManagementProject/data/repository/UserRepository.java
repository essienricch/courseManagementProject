package org.example.courseManagementProject.data.repository;

import org.example.courseManagementProject.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <AppUser, Long> {

    AppUser getAppUserByEmail(String email);

    Boolean existsByEmail(String email);
}
