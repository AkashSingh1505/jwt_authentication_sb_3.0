package com.practice.jwt_authentication_sb_30.service;

import com.practice.jwt_authentication_sb_30.entity.Role;
import com.practice.jwt_authentication_sb_30.entity.User;
import com.practice.jwt_authentication_sb_30.model.RegisterRequestBody;
import com.practice.jwt_authentication_sb_30.repository.RoleRepository;
import com.practice.jwt_authentication_sb_30.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public ResponseEntity<?> register(RegisterRequestBody requestBody) {
        if(requestBody!=null){
        Set<Role> roles = roleRepository.findByNameIn(requestBody.getRolesName());
        User user = new User(-1,requestBody.getName(),requestBody.getEmail(),passwordEncoder.encode(requestBody.getPassword()),roles);
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
        }else{
            return new ResponseEntity("Unable to create user",HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity(userRepository.findAll(),HttpStatus.FOUND);
    }
}
