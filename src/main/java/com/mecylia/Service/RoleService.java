package com.mecylia.Service;

import com.mecylia.model.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service


public interface RoleService {
    //Save a Role Entity to the database.
    Role save(Role role);

    // Add a role to a user
    void addRoleToUser(String user, String roleName);

}
