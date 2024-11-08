package com.mecylia.Demo;

import com.mecylia.Service.RoleService;
import com.mecylia.Service.UserService;
import com.mecylia.Service.impl.RoleServiceImpl;
import com.mecylia.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class DataLoaderSecurity implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;
    private final RoleServiceImpl roleServiceImpl;


    @Override
    public void run(String... args) throws Exception {
        roleService.save(new Role("ROLE_ADMIN"));
        roleService.save(new Role("ROLE_USER"));


        roleService.addRoleToUser("Pauline75", "ROLE_USER");
        roleService.addRoleToUser("Salmaben", "ROLE_USER");
        roleService.addRoleToUser("Carmend", "ROLE_USER");
        roleService.addRoleToUser("JulieD", "ROLE_ADMIN");

    }
}

