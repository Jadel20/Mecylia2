package com.mecylia.Service.impl;

import com.mecylia.Repository.RoleRepository;
import com.mecylia.Repository.UserRepository;
import com.mecylia.Service.RoleService;
import com.mecylia.model.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.mecylia.model.User;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    //Add role to the user with the given username
    @Override
    public Role save(Role role) {
        log.info("Saving new role: {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
    log.info("adding role {} to user {}", roleName, username);

    //Retrieve the user and role objects from the repository
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);

        //Add the role to the user's role collection
        user.getRoles().add(role);
        userRepository.save(user);
    }
}


