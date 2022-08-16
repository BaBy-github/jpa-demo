package com.example.jpademo.controller;

import com.example.jpademo.RBAC.entity.Permission;
import com.example.jpademo.RBAC.entity.Role;
import com.example.jpademo.RBAC.entity.User;
import com.example.jpademo.RBAC.repository.PermissionRepo;
import com.example.jpademo.RBAC.repository.RoleRepo;
import com.example.jpademo.RBAC.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class RBACControllerTest {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PermissionRepo permissionRepo;

    @BeforeEach
    void setUp(){
        userRepo.deleteAll();
        roleRepo.deleteAll();
        permissionRepo.deleteAll();
    }

    @Test
    void doSetUp(){
    }

    @Test
    void saveUserAndRoleAndPermission(){
        Role role = new Role("admin");
        Permission permission1 = permissionRepo.save(new Permission("USER:INSERT"));
        Permission permission2 = permissionRepo.save(new Permission("USER:UPDATE"));
        role.setPermissions(new HashSet<>(){{
            add(permission1);
            add(permission2);
        }});
        Role savedRole = roleRepo.save(role);

        User user = new User("123", "123");

        user.setRoles(new HashSet<>(){{add(savedRole);}});
        User savedUser = userRepo.save(user);
    }
}