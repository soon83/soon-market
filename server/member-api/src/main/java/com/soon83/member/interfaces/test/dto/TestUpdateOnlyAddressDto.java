package com.soon83.member.interfaces.test.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class TestUpdateOnlyAddressDto {

    @NotNull
    private Long id;

    @NotBlank
    @Length(min = 2, max = 128)
    private String address;
}
