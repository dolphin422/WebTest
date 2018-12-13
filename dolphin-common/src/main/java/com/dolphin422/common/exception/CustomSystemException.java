package com.dolphin422.common.exception;

/**
 * @Description: 自定义系统异常
 * @author: DamonJT WIN
 * @createDate: 2018.12.11 0:13
 */
public class CustomSystemException extends BaseCustomException {
    private static final long serialVersionUID = 2811851714651135795L;

    /**
     * 构造函数
     *
     * @param exceptionDesc the exception description
     */
    public CustomSystemException(Enum<? extends IExceptionStatusEnum> exceptionDesc) {
        super(exceptionDesc);
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the exception description
     * @param exception     the exception
     */
    public CustomSystemException(Enum<? extends IExceptionStatusEnum> exceptionDesc,
        Throwable exception) {
        super(exceptionDesc, exception);
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the exception description
     * @param message       the message
     */
    public CustomSystemException(Enum<? extends IExceptionStatusEnum> exceptionDesc,
        String message) {
        super(exceptionDesc, message);
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the exception description
     * @param message       the message
     * @param args          the args
     */
    public CustomSystemException(Enum<? extends IExceptionStatusEnum> exceptionDesc,
        String message, Object... args) {
        super(exceptionDesc, message, args);
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the exception description
     * @param exception     the exception
     * @param message       the message
     */
    public CustomSystemException(Enum<? extends IExceptionStatusEnum> exceptionDesc,
        Throwable exception, String message) {
        super(exceptionDesc, exception, message);
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the exception description
     * @param exception     the exception
     * @param message       the message
     * @param args          the args
     */
    public CustomSystemException(Enum<? extends IExceptionStatusEnum> exceptionDesc,
        Throwable exception, String message, Object... args) {
        super(exceptionDesc, exception, message, args);
    }
}
