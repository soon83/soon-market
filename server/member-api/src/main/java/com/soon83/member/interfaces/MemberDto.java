package com.soon83.member.interfaces;

import com.soon83.member.domain.MemberCommand;
import com.soon83.member.domain.MemberInfo;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MemberDto {

    @Data
    public static class RegisterRequest {
        @NotBlank(message = "name 은 필수입니다.")
        private String memberName;

        @Email(message = "email 형식 똑바로 안하냐..")
        @NotBlank(message = "email 은 필수입니다.")
        private String memberEmail;

        public MemberCommand toCommand() {
            return MemberCommand.builder()
                    .name(memberName)
                    .email(memberEmail)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class GetResponse {
        private final Long memberId;
        private final String memberToken;
        private final String memberName;
        private final String memberEmail;

        public GetResponse(MemberInfo memberInfo) {
            this.memberId = memberInfo.getId();
            this.memberToken = memberInfo.getToken();
            this.memberName = memberInfo.getName();
            this.memberEmail = memberInfo.getEmail();
        }
    }

    @Getter
    @ToString
    public static class RegisterResponse {
        private final Long memberId;
        private final String memberToken;
        private final String memberName;
        private final String memberEmail;

        public RegisterResponse(MemberInfo memberInfo) {
            this.memberId = memberInfo.getId();
            this.memberToken = memberInfo.getToken();
            this.memberName = memberInfo.getName();
            this.memberEmail = memberInfo.getEmail();
        }
    }
}
