package com.example.test.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class memberDto {
    String email;
    String password;
}
