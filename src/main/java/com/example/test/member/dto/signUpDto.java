package com.example.test.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class signUpDto {
    String email;
    String username;
    String password;
}
