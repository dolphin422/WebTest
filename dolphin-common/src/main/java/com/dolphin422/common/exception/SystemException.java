package com.dolphin422.common.exception;

import com.dolphin422.common.base.BaseException;
import com.dolphin422.common.base.IBaseStatusCodeEnum;
import com.dolphin422.common.enumeration.statuscode.system.SystemExceptionEnum;

/**
 * @Description: 自定义系统异常
 * @author: DamonJT WIN
 * @createDate: 2018.12.11 0:13
 */
public class SystemException extends BaseException {
    private static final long serialVersionUID = 2811851714651135795L;


    @Override
    public SystemExceptionEnum getExceptionCode() {
        return (SystemExceptionEnum)super.exceptionCode;
    }

    /**
     * 构造函数
     *
     * @param systemExceptionCode systemExceptionCode
     */
    public SystemException(Enum<? extends IBaseStatusCodeEnum> systemExceptionCode) {
        super(systemExceptionCode);
    }

    /**
     * 构造函数
     *
     * @param systemExceptionCode systemExceptionCode
     * @param exception           the system
     */
    public SystemException(SystemExceptionEnum systemExceptionCode,
        Throwable exception) {
        super(systemExceptionCode, exception);
    }

    /**
     * 构造函数
     *
     * @param systemExceptionCode systemExceptionCode
     * @param message             the message
     */
    public SystemException(SystemExceptionEnum systemExceptionCode,
        String message) {
        super(systemExceptionCode, message);
    }

    /**
     * 构造函数
     *
     * @param systemExceptionCode systemExceptionCode
     * @param message             the message
     * @param args                the args
     */
    public SystemException(SystemExceptionEnum systemExceptionCode,
        String message, Object... args) {
        super(systemExceptionCode, message, args);
    }

    /**
     * 构造函数
     *
     * @param systemExceptionCode systemExceptionCode
     * @param exception           the system
     * @param message             the message
     */
    public SystemException(SystemExceptionEnum systemExceptionCode,
        Throwable exception, String message) {
        super(systemExceptionCode, exception, message);
    }

    /**
     * 构造函数
     *
     * @param systemExceptionCode systemExceptionCode
     * @param exception           the system
     * @param message             the message
     * @param args                the args
     */
    public SystemException(SystemExceptionEnum systemExceptionCode,
        Throwable exception, String message, Object... args) {
        super(systemExceptionCode, exception, message, args);
    }
}
