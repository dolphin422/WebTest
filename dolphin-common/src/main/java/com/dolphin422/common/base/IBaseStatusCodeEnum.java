package com.dolphin422.common.base;

/**
 * @Description: 状态码枚举值基类
 * @author: DamonJT WIN
 * @createDate: 2018.12.11 0:08
 */
public interface IBaseStatusCodeEnum {
    /**
     * 获取状态码
     * @return
     */
    String getStatusCode();

    /**
     * 获取状态说明
     * @return
     */
    String getDescription();
}
