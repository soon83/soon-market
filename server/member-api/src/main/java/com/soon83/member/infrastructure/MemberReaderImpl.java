package com.soon83.member.infrastructure;

import com.soon83.member.domain.Member;
import com.soon83.member.domain.MemberReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberReaderImpl implements MemberReader {

    @Override
    public Member getMember(String memberToken) {
        return null;
    }
}
