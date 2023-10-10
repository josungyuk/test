package com.example.test.member.controller;

import com.example.test.member.dto.member2Dto;
import com.example.test.member.dto.memberDto;
import com.example.test.member.dto.signUpDto;
import com.example.test.member.entity.Member;
import com.example.test.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

//    @GetMapping("")
//    public ResponseEntity base(){
//        return new ResponseEntity(true, HttpStatus.OK);
//    }

    @PostMapping("/login")
    public String login(@ModelAttribute memberDto dto2){
        memberDto dto = memberDto.builder()
                .email(dto2.getEmail())
                .password(dto2.getPassword())
                .build();

        boolean isLogin = memberService.login(dto);

        if(isLogin) return "성공";

        return "실패";
    }

    @GetMapping("/get")
    public ResponseEntity get(@RequestBody String email){
        Member member = memberService.get(email);

        return new ResponseEntity(member, HttpStatus.OK);
    }

    @PostMapping("/create")
    public String create(@ModelAttribute signUpDto dto){
        Long id = memberService.signUp(dto);

        if(id == -1L) return "redirect:/signup.html";

        return "index";
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody memberDto dto2){
        memberDto dto = memberDto.builder()
                .email(dto2.getEmail())
                .password(dto2.getPassword())
                .build();

        boolean isDeleted = memberService.delete(dto);

        return new ResponseEntity(isDeleted, HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity update(@ModelAttribute member2Dto dto2){
        member2Dto dto = member2Dto.builder()
                .email(dto2.getEmail())
                .newPassword(dto2.getNewPassword())
                .oldPassword(dto2.getOldPassword())
                .build();

        Member member = memberService.update(dto);

        return new ResponseEntity(member, HttpStatus.OK);
    }
}
