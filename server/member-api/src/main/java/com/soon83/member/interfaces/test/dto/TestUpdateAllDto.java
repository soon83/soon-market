package com.soon83.member.interfaces.test.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Data
public class TestUpdateAllDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String gender;

    @NotBlank
    @Pattern(regexp = "/^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/", message="휴대폰번호는 010-1234-5678 의 형태이어야 합니다.")
    private String phone;

    @NotBlank
    @Length(min = 2, max = 128)
    private String address;

    @PositiveOrZero
    private Integer age;

    private Integer height;

    private Integer weight;
}