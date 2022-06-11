package com.soon83.member.common.exception;

import com.soon83.member.common.response.ErrorCode;

public class MemberNotFoundException extends BaseException {

    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }

    public MemberNotFoundException(String message) {
        super(message, ErrorCode.MEMBER_NOT_FOUND);
    }
}