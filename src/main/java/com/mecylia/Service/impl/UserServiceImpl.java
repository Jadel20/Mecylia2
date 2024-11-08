package com.mecylia.Service.impl;

import com.mecylia.Repository.UserRepository;
import com.mecylia.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    //Loads the user by its username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //retrieve user with give username
        User user = userRepository.findByUsername(username);
        //check if user exists
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database {}", username);
            //create a collection of SimpleGrantedAuthority objects from the user's role
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role->{
                authorities.add(new SimpleGrantedAuthority(role.getName));
            });
            //return user details; username, password and authorities
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }

    //Save new user to db
    @Override
    public User saveUser(User user) {
        log.info("saving new user {} to the database", user.getName());
        //Encode user's password for security before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
// Retrieve the user with the given username
    @Override
    public User getUser(String username) {
        log.info("Fetching user {} from the database", username);
        return userRepository.findByUsername(username);
    }
//Return a list of all users
    @Override
    public List<User> getUsers() {
        log.info("Fetching all users from the database");
        return userRepository.findAll();
    }


}

