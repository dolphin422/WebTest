package com.dolphin422.common.exception;

import com.dolphin422.common.base.BaseException;
import com.dolphin422.common.enumeration.statuscode.business.BusinessExceptionEnum;

/**
 * @Description: 自定义业务异常类
 * @author: DamonJT WIN
 * @createDate: 2018.12.11 0:12
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 2203764194341374713L;

    /**
     * @return exceptionCode
     */
    @Override
    public BusinessExceptionEnum getExceptionCode() {
        return (BusinessExceptionEnum) super.exceptionCode;
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the system description
     */
    public BusinessException(BusinessExceptionEnum exceptionDesc) {
        super(exceptionDesc);
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the system description
     * @param exception     the system
     */
    public BusinessException(BusinessExceptionEnum exceptionDesc,
        Throwable exception) {
        super(exceptionDesc, exception);
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the system description
     * @param message       the message
     */
    public BusinessException(BusinessExceptionEnum exceptionDesc,
        String message) {
        super(exceptionDesc, message);
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the system description
     * @param message       the message
     * @param args          the args
     */
    public BusinessException(BusinessExceptionEnum exceptionDesc,
        String message, Object... args) {
        super(exceptionDesc, message, args);
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the system description
     * @param exception     the system
     * @param message       the message
     */
    public BusinessException(BusinessExceptionEnum exceptionDesc,
        Throwable exception, String message) {
        super(exceptionDesc, exception, message);
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the system description
     * @param exception     the system
     * @param message       the message
     * @param args          the args
     */
    public BusinessException(BusinessExceptionEnum exceptionDesc,
        Throwable exception, String message, Object... args) {
        super(exceptionDesc, exception, message, args);
    }

}
