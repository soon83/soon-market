package com.soon83.member.config;

import com.soon83.member.common.enumcode.EnumMapper;
import com.soon83.member.domain.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnumConfig {

    @Bean
    public EnumMapper enumMapper() {
        EnumMapper enumMapper = new EnumMapper();
        enumMapper.put("memberStatus", Member.Status.class);
        return enumMapper;
    }
}
