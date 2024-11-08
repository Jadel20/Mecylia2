package com.mecylia.Service;

import com.mecylia.model.User;

import java.util.List;

public interface UserService {
    /**
     * @param user
     * @return
     */
    //Save User entity to the database
    User saveUser (User user);

    //Retrieve User from the database
    User getUser (String username);

    //Return a list of Users
    List<User> getUsers();

}
