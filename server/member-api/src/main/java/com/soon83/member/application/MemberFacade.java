package com.soon83.member.application;

import com.soon83.member.domain.MemberInfo;
import com.soon83.member.domain.MemberService;
import com.soon83.member.domain.MemberCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberService memberService;

    public MemberInfo retrieveMember(String memberToken) {
        return memberService.retrieveMember(memberToken);
    }

    public MemberInfo registerMember(MemberCommand command) {
        return memberService.registerMember(command);
    }
}
