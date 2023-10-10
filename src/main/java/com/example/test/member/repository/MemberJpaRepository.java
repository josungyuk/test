package com.example.test.member.repository;

import com.example.test.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member as m where m.email = :email")
    public Member findByEmail(String email);
}
