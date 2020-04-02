package com.graduation.experimentjudge.util;

/**
 * @author kurizcan
 * @date 2020/04/01 23:24
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS(200),
    /**
     * 无权限
     */
    UN_AUTHORIZATION(401),
    /**
     * 登陆失败
     */
    LOGIN_FAIL(402),
    /**
     * 更新、插入失败
     */
    UPDATE_OR_INSERT_DATA_FAIL(402),
    ;

    private int code;

    public int getCode()
    {
        return code;
    }

    ResultCode(int code)
    {
        this.code = code;
    }

}
