package org.example.courseManagementProject.service.roleService;

import org.example.courseManagementProject.data.model.Role;
import org.example.courseManagementProject.data.repository.RoleRepository;
import org.example.courseManagementProject.exception.userexception.RoleDbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }



    @Override
    public Role savedRole(Role role) throws RoleDbException {
        if (roleRepository.existsByRoleName(role.getRoleName())){
            throw new RoleDbException("Role Already exist");
        }else {
          Role savedRole =  roleRepository.save(role);
          return savedRole;
        }
    }

    @Override
    public void deleteRole(Role role) throws RoleDbException {
        Role savedRole = findRole(role.getRoleName());
        if (savedRole != null){
            roleRepository.delete(savedRole);
        }else throw new RoleDbException("Role not found");
    }

    @Override
    public Role findRole(String roleName) throws RoleDbException {
        Role savedRole = roleRepository.findRoleByRoleName(roleName.toUpperCase());
        if (savedRole != null)return savedRole;
        else throw new RoleDbException("Role does not exist");
    }

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }
}
