package com.dolphin422.common.enumeration.statuscode.system;

import com.dolphin422.common.base.IBaseStatusCodeEnum;

/**
 * @Description:
 * @author: DamonJT WIN
 * @createDate: 2018.12.14 2:09
 */
public enum SystemExceptionCodeEnum implements IBaseStatusCodeEnum {
    ERROR("700", "系统错误") {},
    TIME_OUT("701", "连接超时") {};

    @Override
    public String getStatusCode() {
        return statusCode;
    }

    @Override
    public String getDescription() {
        return description;
    }

    /**
     * 状态码
     */
    private String statusCode;

    /**
     * 描述
     */
    private String description;

    /**
     * 构造方法
     *
     * @param statusCode  状态码
     * @param description 描述
     */
    SystemExceptionCodeEnum(String statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 默认的toString方法返回的就是枚举变量的名字，和name()方法返回值一样
     *
     * @return
     */
    @Override
    public String toString() {
        return "[" + this.statusCode + ":" + this.description + "]";
    }

}

