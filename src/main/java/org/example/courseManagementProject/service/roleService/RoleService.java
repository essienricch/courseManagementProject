package org.example.courseManagementProject.service.roleService;

import org.example.courseManagementProject.data.model.Role;
import org.example.courseManagementProject.exception.userexception.RoleDbException;

import java.util.List;

public interface RoleService {

    Role savedRole(Role role) throws RoleDbException;
    void deleteRole(Role role) throws RoleDbException;
    Role findRole(String roleName) throws RoleDbException;
    List <Role> findAllRole();
}
