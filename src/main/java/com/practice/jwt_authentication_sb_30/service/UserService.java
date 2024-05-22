package com.practice.jwt_authentication_sb_30.service;

import com.practice.jwt_authentication_sb_30.entity.User;
import com.practice.jwt_authentication_sb_30.model.RegisterRequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    ResponseEntity<?> register(RegisterRequestBody requestBody);
    ResponseEntity<List<User>> getAll();
}
