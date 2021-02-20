package org.xzw.cloudalibabaproviderpayment9002.enums;

import lombok.Getter;

@Getter
public enum ResultStatus {

    SUCCESS(1000, "返回数据成功"),
    FAIL(1001, "返回数据失败"),
    ILLEGAL(1002, "非法访问"),
    PARAM_ERROR(1003, "参数错误"),
    AUTHORIZE_ERROR(1004, "授权失败");

    int code;
    String desc;

    ResultStatus(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
