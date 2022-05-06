package com.soon83.member.interfaces.test;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Data
public class TestDto {
    interface SelectConditions {} // 조회 조건
    interface Create {} // 단건 생성
    interface UpdateOnlyPhone {} // 사용자 휴대폰번호 인증 후 번호만 변경
    interface UpdateOnlyAddress {} // 사용자 주소 인증 후 주소만 변경
    interface UpdateAll {}

    @NotNull(groups = {UpdateAll.class,UpdateOnlyPhone.class,UpdateOnlyAddress.class,})
    private Long id;

    @NotBlank(groups = {Create.class,UpdateAll.class,})
    @Length(min = 2, max = 10, groups = {SelectConditions.class,})
    private String name;

    @NotBlank(groups = {Create.class,UpdateAll.class,})
    private String gender;

    @NotBlank(groups = {Create.class,UpdateAll.class,})
    @Pattern(regexp = "/^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/", message="휴대폰번호는 010-1234-5678 의 형태이어야 합니다.",
            groups = {SelectConditions.class,Create.class,UpdateAll.class,UpdateOnlyPhone.class,})
    private String phone;

    @NotBlank(groups = {Create.class,UpdateAll.class,})
    @Length(min = 2, max = 128,
            groups = {Create.class,UpdateAll.class,})
    private String address;

    @PositiveOrZero(groups = {Create.class,UpdateAll.class,})
    private Integer age;

    @PositiveOrZero(groups = {Create.class,})
    private Integer height;

    @PositiveOrZero(groups = {Create.class,})
    private Integer weight;
}
