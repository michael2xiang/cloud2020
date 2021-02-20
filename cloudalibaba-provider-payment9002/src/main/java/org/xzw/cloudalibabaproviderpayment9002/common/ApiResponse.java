package org.xzw.cloudalibabaproviderpayment9002.common;

import org.xzw.cloudalibabaproviderpayment9002.enums.ResultStatus;
import lombok.Data;

@Data
public class ApiResponse<T> {

    private int code;

    private int bCode;

    private String message;

    private T content;

    private long timeStamp;

    public ApiResponse() {
        this(null);
    }

    public ApiResponse(T data) {
        this(ResultStatus.SUCCESS.getCode(), ResultStatus.SUCCESS.getDesc(), data);
    }

    public ApiResponse(int code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
        this.timeStamp = System.currentTimeMillis();
    }

    public ApiResponse(int code, int bCode, String message, T content) {
        this.code = code;
        this.bCode = bCode;
        this.message = message;
        this.content = content;
        this.timeStamp = System.currentTimeMillis();
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse<>(data);
    }

    public static ApiResponse failure(String message) {
        return failure(ResultStatus.FAIL.getCode(), message);
    }

    public static ApiResponse failure(int statusCode, String message) {
        return new ApiResponse<>(statusCode, message, null);
    }
}
