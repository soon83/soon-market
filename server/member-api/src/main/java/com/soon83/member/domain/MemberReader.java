package com.soon83.member.domain;

import java.util.List;

public interface MemberReader {

    List<MemberInfo> getMembers();

    MemberInfo getMember(String memberToken);
}
