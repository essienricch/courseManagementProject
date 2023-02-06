package org.example.courseManagementProject.service.roleService;

import org.example.courseManagementProject.data.model.Role;
import org.example.courseManagementProject.exception.userexception.RoleDbException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleServiceImplTest {

    @Autowired
    private RoleServiceImpl roleService;
    private Role role;
    private Role role1;

    @BeforeEach
    void setUp(){
        role = new Role("USER");
        role1 = new Role("ADMIN");
    }

    @Test
    void saveUserRoleTest() throws RoleDbException {
        try{
        Role savedRole = roleService.savedRole(role);
        assertNotNull(savedRole.getRoleName());
        }catch (RoleDbException e){
            e.printStackTrace();
        }
    }


    @Test
    void saveAdminRoleTest() throws RoleDbException {
        try{
            Role savedRole = roleService.savedRole(role1);
            assertNotNull(savedRole.getRoleName());
        }catch (RoleDbException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void findRoleTest() throws RoleDbException {
        try{
        Role savedRole = roleService.findRole("user");
        assertEquals("USER", savedRole.getRoleName());
        }catch (RoleDbException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void deleteRoleTest(){
        Role innerRole  =  new Role("USER");

        try{
            roleService.deleteRole(innerRole);
        assertNull(innerRole);
        }catch (RoleDbException e){
            System.out.println(e.getMessage());
        }
    }

}