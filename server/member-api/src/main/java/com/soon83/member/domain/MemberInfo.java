package com.soon83.member.domain;

import lombok.Getter;

@Getter
public class MemberInfo {

    private Long id;
    private String token;
    private String name;
    private String email;

    public MemberInfo(Member entity) {
        this.id = entity.getId();
        this.token = entity.getToken();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }
}
