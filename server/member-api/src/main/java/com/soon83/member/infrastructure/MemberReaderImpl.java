package com.soon83.member.infrastructure;

import com.soon83.member.domain.MemberInfo;
import com.soon83.member.domain.MemberReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberReaderImpl implements MemberReader {

    private final MemberRepository memberRepository;

    @Override
    public MemberInfo getMember(String memberToken) {
        return memberRepository.findByToken(memberToken)
                .map(MemberInfo::new)
                .orElseThrow(() -> new RuntimeException("그런 사람 또 없습니다. -이승철-"));
    }
}
