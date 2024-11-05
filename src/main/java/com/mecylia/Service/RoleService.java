package com.mecylia.Service;


import com.mecylia.Repository.RoleRepository;
import com.mecylia.Repository.UserRepository;
import com.mecylia.model.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public void save(Role roleAdmin) {
        log.info("Saving new role {} to the database");
        roleRepository.save(roleAdmin);
    }

    public void addRoleToUser(String user, String role) {
       // log.info("Adding role {} to user {}", role, user.getUsername());

        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);

        // Add the role to the user's role collection
        user.getRoles().add(role);

        // Save the user to persist the changes
        userRepository.save(user);



    }
}
