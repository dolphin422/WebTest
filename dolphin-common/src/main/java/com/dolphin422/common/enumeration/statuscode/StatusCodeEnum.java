package com.dolphin422.common.enumeration.statuscode;

import com.dolphin422.common.exception.IExceptionStatusEnum;

/**
 * @Description: 状态码枚举类
 * @author: DamonJT WIN
 * @createDate: 2018.12.11 23:39
 */
public enum StatusCodeEnum implements IExceptionStatusEnum {

    SUCCESS("200", "操作成功"),
    FAILURE("600", "操作失败"),
    LACK_ARGUMENT("450", "缺少参数");

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
     * @param statusCode 状态码
     * @param description    信息
     */
    StatusCodeEnum(String statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
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
        return this.statusCode + ":" + this.description;
    }

}
