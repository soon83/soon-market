package com.soon83.member.domain;

public interface MemberService {

    MemberInfo retrieveMember(String memberToken);

    MemberInfo registerMember(MemberCommand command);
}
