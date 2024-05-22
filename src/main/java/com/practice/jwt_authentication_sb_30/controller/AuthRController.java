package com.practice.jwt_authentication_sb_30.controller;


import com.practice.jwt_authentication_sb_30.config.JWtUtil;
import com.practice.jwt_authentication_sb_30.model.LoginRequestBody;
import com.practice.jwt_authentication_sb_30.model.LoginResponseBody;
import com.practice.jwt_authentication_sb_30.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthRController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWtUtil jWtUtil;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestBody loginRequestBody){
        this.doAuthenticate(loginRequestBody.getEmail(), loginRequestBody.getPassword());

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequestBody.getEmail());
        String token = jWtUtil.generateToken(userDetails);
        return new ResponseEntity<>(new LoginResponseBody(token),HttpStatus.OK);
    }

    private void doAuthenticate(String email,String password){

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(email,password);
        try{
            authenticationManager.authenticate(auth);
        }catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid!!";
    }


}
