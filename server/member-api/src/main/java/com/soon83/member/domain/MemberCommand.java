package com.soon83.member.domain;

import lombok.Builder;
import lombok.Data;

public class MemberCommand {

    @Data
    @Builder
    public static class RegisterMember {
        private final Long memberId;
        private final String name;
        private final String email;

        public Member toEntity() {
            return Member.builder()
                    .token("1234567890")
                    .name(name)
                    .email(email)
                    .build();
        }
    }
}
