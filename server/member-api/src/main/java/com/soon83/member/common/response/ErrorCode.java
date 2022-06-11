package com.soon83.member.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    /**
     * System Error
     * 0000
     */
    COMMON_SYSTEM_ERROR("0000", "일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."), // 장애 상황
    COMMON_INVALID_PARAMETER("0001","요청한 값이 올바르지 않습니다."),
    COMMON_ENTITY_NOT_FOUND("0002","존재하지 않는 엔티티입니다."),
    COMMON_ILLEGAL_STATUS("0003","잘못된 상태값입니다."),

    /**
     * Member Error
     * 1000
     */
    MEMBER_NOT_FOUND("1000","존재하지 않는 회원입니다.");

    private final String errorNumber;
    private final String errorMessage;

    public String getErrorMessage(Object... arg) {
        return String.format(errorMessage, arg);
    }
}