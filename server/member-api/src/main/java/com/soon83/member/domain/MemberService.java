package com.soon83.member.domain;

import java.util.List;

public interface MemberService {

    List<MemberInfo> retrieveMembers();

    MemberInfo retrieveMember(String memberToken);

    MemberInfo registerMember(MemberCommand command);
}
