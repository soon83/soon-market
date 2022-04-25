package com.soon83.member.infrastructure;

import com.soon83.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByToken(String memberToken);
}
