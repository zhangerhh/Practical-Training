package com.demo.commons.utils;

import com.demo.commons.domain.Result;
import com.demo.commons.domain.enums.SystemEnum;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/14
 * @time: 15:14
 */
public class ResultUtils {

    /**
     * 基础返回方法
     *
     * @param code 状态码
     * @param msg  状态信息
     * @param data 数据
     * @return result
     */
    public static Result normalResult(Integer code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    /**
     * 访问成功用
     *
     * @param data 数据
     * @return result
     */
    public static Result success(Object data) {
        return normalResult(SystemEnum.SYSTEM_AUTH_SUCCESS.getCode(), SystemEnum.SYSTEM_AUTH_SUCCESS.getMsg(), data);
    }

    /**
     * 访问失败用
     *
     * @param data 数据
     * @return result
     */
    public static Result fail(Object data) {
        return normalResult(SystemEnum.SYSTEM_AUTH_FAIL.getCode(), SystemEnum.SYSTEM_AUTH_FAIL.getMsg(), data);
    }

    /**
     * 访问失败用
     *
     * @param data 数据
     * @param msg  错误状态信息
     * @return result
     */
    public static Result fail(String msg, Object data) {
        return normalResult(SystemEnum.SYSTEM_AUTH_FAIL.getCode(), msg, data);
    }

    /**
     * 没有找到页面
     *
     * @return
     */
    public static Result notFound() {
        return normalResult(SystemEnum.SYSTEM_NOT_FOUND.getCode(), SystemEnum.SYSTEM_NOT_FOUND.getMsg(), null);
    }

    /**
     * 授权模式错误
     *
     * @return
     */
    public static Result grantTypeError() {
        return normalResult(SystemEnum.SYSTEM_GRANT_TYPE_ERROR.getCode(), SystemEnum.SYSTEM_GRANT_TYPE_ERROR.getMsg(), null);
    }

}
