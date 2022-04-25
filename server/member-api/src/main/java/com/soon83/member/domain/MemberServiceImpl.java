package com.soon83.member.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberReader memberReader;
    private final MemberStore memberStore;

    @Override
    @Transactional(readOnly = true)
    public MemberInfo retrieveMember(String memberToken) {
        return memberReader.getMember(memberToken);
    }

    @Override
    @Transactional
    public MemberInfo registerMember(MemberCommand memberCommand) {
        var member = memberStore.store(memberCommand.toEntity());
        return new MemberInfo(member);
    }
}
