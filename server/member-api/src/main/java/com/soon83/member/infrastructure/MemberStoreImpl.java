package com.soon83.member.infrastructure;

import com.soon83.member.domain.Member;
import com.soon83.member.domain.MemberStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberStoreImpl implements MemberStore {

    private final MemberRepository memberRepository;

    @Override
    public Member store(Member member) {
        return memberRepository.save(member);
    }
}
