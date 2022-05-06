package com.soon83.member.interfaces.test;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Data
public class TestUpdateAllDto extends TestDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String gender;

    @NotBlank
    @Length(min = 2, max = 128)
    private String address;

    @PositiveOrZero
    private Integer age;

}
