package com.example.test.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class member2Dto {
    String email;
    String oldPassword;
    String newPassword;
}
