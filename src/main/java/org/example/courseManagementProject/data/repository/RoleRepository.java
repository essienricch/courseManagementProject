package org.example.courseManagementProject.data.repository;

import org.example.courseManagementProject.data.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository <Role, Integer> {
    Role findRoleByRoleName(String roleName);
    boolean existsByRoleName(String roleName);
}
