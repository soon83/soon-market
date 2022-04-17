package com.soon83.member.interfaces;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MemberDto {

    @Data
    @Builder
    public static class GetResponse {
        private String token;
        private String name;
        private String email;
    }

    @Data
    public static class RegisterRequest {
        @NotBlank(message = "name 은 필수입니다.")
        private String name;

        @Email(message = "email 형식 똑바로 안하냐..")
        @NotBlank(message = "email 은 필수입니다.")
        private String email;
    }

    @Data
    @Builder
    public static class RegisterResponse {
        private String token;
        private String name;
        private String email;
    }
}
