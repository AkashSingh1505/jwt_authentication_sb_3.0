package com.practice.jwt_authentication_sb_30.model;

import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestBody {
    @NonNull
    String name;
    @NonNull
    String email;
    @NonNull
    String password;
    Set<String> rolesName = new HashSet();
}
