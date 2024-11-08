package com.mecylia.Controller;


import com.mecylia.DTO.RoleToUserDTO;
import com.mecylia.Service.RoleService;
import com.mecylia.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

   //Save a new role
    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody Role role)
    {roleService.save(role);
    }

    //Add a role to a user
    @PostMapping("/roles/add-to-user")
    @ResponseStatus(HttpStatus.OK)
    public void addRoleToUser(@RequestBody RoleToUserDTO roleToUserDTO) {
        roleService.addRoleToUser(roleToUserDTO.getUsername(), roleToUserDTO.getRoleName());
    }
}