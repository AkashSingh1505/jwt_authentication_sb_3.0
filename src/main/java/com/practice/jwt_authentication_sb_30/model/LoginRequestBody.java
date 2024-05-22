package com.practice.jwt_authentication_sb_30.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestBody {
    @NonNull
    String email;

    @NonNull
    String password;
}
