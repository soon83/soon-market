package com.soon83.member.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private Result result;
    private boolean success;
    private T data;
    private String message;
    private String errorCode;
    private String errorNumber;

    public static <T> CommonResponse<T> success(T data) {
        return success(data, null);
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        return (CommonResponse<T>) CommonResponse.builder()
                .success(true)
                .result(Result.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    public static CommonResponse failure(String message, String errorCode) {
        return CommonResponse.builder()
                .success(false)
                .result(Result.FAILURE)
                .message(message)
                .errorCode(errorCode)
                .build();
    }

    public static CommonResponse failure(String message, ErrorCode errorCode) {
        return CommonResponse.builder()
                .success(false)
                .result(Result.FAILURE)
                .message(message)
                .errorCode(errorCode.name())
                .errorNumber(errorCode.getErrorNumber())
                .build();
    }

    public static CommonResponse failure(ErrorCode errorCode) {
        return CommonResponse.builder()
                .success(false)
                .result(Result.FAILURE)
                .message(errorCode.getErrorMessage())
                .errorCode(errorCode.name())
                .errorNumber(errorCode.getErrorNumber())
                .build();
    }

    public enum Result {
        SUCCESS,
        FAILURE;
    }
}