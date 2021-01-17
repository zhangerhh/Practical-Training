package com.demo.commons.domain.enums;

import com.demo.commons.domain.Commons;

public enum SystemEnum {

    SYSTEM_AUTH_SUCCESS(200, "token获取成功"),
    SYSTEM_AUTH_REFRESH_TOKEN_SUCCESS(201, "token刷新成功"),

    SYSTEM_NOT_FOUND(404, "url not found"),
    SYSTEM_AUTH_UNKNOWN_USER(501, "非法用户"),
    SYSTEM_AUTH_FAIL(500, "授权失败"),
    SYSTEM_AUTH_TOKEN_UNEXP(502, "token已过期"),
    SYSTEM_USER_NOT_FOUNT(503, Commons.USER_NOT_FOUND),
    SYSTEM_PASSWORD_ERROR(504, Commons.PASSWORD_ERROR),
    SYSTEM_GRANT_TYPE_ERROR(505, "grantType error");

    private Integer code;
    private String msg;

    SystemEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
