package com.example.test.member.service;

import com.example.test.member.dto.member2Dto;
import com.example.test.member.dto.memberDto;
import com.example.test.member.dto.signUpDto;
import com.example.test.member.entity.Member;
import com.example.test.member.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberJpaRepository memberJpaRepository;

    public boolean login(memberDto dto){
        Member member = memberJpaRepository.findByEmail(dto.getEmail());

        if(member == null) return false;

        if(member.getEmail().equals(dto.getEmail()) && member.getPassword().equals(dto.getPassword()))
            return true;

        return false;
    }
    public Member get(String email){
        return memberJpaRepository.findByEmail(email);
    }
    public Long signUp(signUpDto dto){
        if(memberJpaRepository.findByEmail(dto.getEmail()) != null)
            return -1L;

        Member member = Member.builder()
                .email(dto.getEmail())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();

        member = memberJpaRepository.save(member);

        Long id = member.getId();

        return id;
    }

    public Member update(member2Dto dto){
        Member member = memberJpaRepository.findByEmail(dto.getEmail());

        if(!member.getPassword().equals(dto.getOldPassword()))
            return null;

        member.setPassword(dto.getNewPassword());

        return memberJpaRepository.save(member);
    }

    public boolean delete(memberDto dto){
        Member member = memberJpaRepository.findByEmail(dto.getEmail());
        if(!member.getPassword().equals(dto.getPassword()))
            return false;

        memberJpaRepository.delete(member);

        return true;
    }
}
