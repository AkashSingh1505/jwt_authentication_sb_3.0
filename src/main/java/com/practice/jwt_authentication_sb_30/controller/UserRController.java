package com.practice.jwt_authentication_sb_30.controller;

import com.practice.jwt_authentication_sb_30.entity.User;
import com.practice.jwt_authentication_sb_30.model.RegisterRequestBody;
import com.practice.jwt_authentication_sb_30.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRController {
    @Autowired
    UserService userService;
    
    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody RegisterRequestBody requestBody){
        return userService.register(requestBody);
    }
    @GetMapping("/getAll")
    ResponseEntity<List<User>> getAll(){
        return userService.getAll();
    }
    
}
