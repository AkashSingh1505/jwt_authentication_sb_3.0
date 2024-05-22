package com.practice.jwt_authentication_sb_30.service;

import com.practice.jwt_authentication_sb_30.entity.User;
import com.practice.jwt_authentication_sb_30.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (email != null) {
            User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No such user found"));
            return user;

        } else {
            throw new IllegalArgumentException("Invalid arguments!!");
        }

    }
}
