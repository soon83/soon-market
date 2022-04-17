package com.soon83.member.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberReader memberReader;
    private final MemberStore memberStore;

    public MemberInfo registerMember(MemberCommand.RegisterMember requestMember) {
        Member member = memberStore.store(requestMember.toEntity());
        return new MemberInfo(member);
    }
}
