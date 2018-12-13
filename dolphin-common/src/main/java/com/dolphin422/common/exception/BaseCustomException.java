package com.dolphin422.common.exception;

/**
 * @Description: 自定义异常类基类
 * @author: DamonJT WIN
 * @createDate: 2018.12.11 0:11
 */
public class BaseCustomException extends RuntimeException {
    private static final long serialVersionUID = -2931700230560392933L;

    /**
     * 异常说明
     */
    private Enum<? extends IExceptionStatusEnum> exceptionDesc;

    /**
     * 构造函数
     *
     * @param exceptionDesc the exception description
     */
    public BaseCustomException(Enum<? extends IExceptionStatusEnum> exceptionDesc) {
        this.exceptionDesc = exceptionDesc;
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the exception description
     * @param throwable     the throwable
     */
    public BaseCustomException(Enum<? extends IExceptionStatusEnum> exceptionDesc,
        Throwable throwable) {
        super(throwable);
        this.exceptionDesc = exceptionDesc;
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the exception description
     * @param message       the message
     */
    public BaseCustomException(Enum<? extends IExceptionStatusEnum> exceptionDesc,
        String message) {
        super(message);
        this.exceptionDesc = exceptionDesc;
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the exception description
     * @param message       the message
     * @param args          the args
     */
    public BaseCustomException(Enum<? extends IExceptionStatusEnum> exceptionDesc,
        String message, Object... args) {
        super(rebuildMessage(message, args));
        this.exceptionDesc = exceptionDesc;
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the exception description
     * @param throwable     the throwable
     * @param message       the message
     */
    public BaseCustomException(Enum<? extends IExceptionStatusEnum> exceptionDesc,
        Throwable throwable, String message) {
        super(message, throwable);
        this.exceptionDesc = exceptionDesc;
    }

    /**
     * 构造函数
     *
     * @param exceptionDesc the exception description
     * @param throwable     the throwable
     * @param message       the message
     * @param args          the args
     */
    public BaseCustomException(Enum<? extends IExceptionStatusEnum> exceptionDesc,
        Throwable throwable, String message, Object... args) {
        super(rebuildMessage(message, args), throwable);
        this.exceptionDesc = exceptionDesc;
    }

    /**
     * @return the exception description
     */
    public Enum<? extends IExceptionStatusEnum> getexceptionDesc() {
        return exceptionDesc;
    }

    /**
     * @param exceptionDesc the exception description
     */
    public void setexceptionDesc(Enum<? extends IExceptionStatusEnum> exceptionDesc) {
        this.exceptionDesc = exceptionDesc;
    }

    /**
     * @return the string
     */
    @Override
    public String toString() {
        return super.toString() + "[异常状态=" + exceptionDesc + "]";
    }

    /**
     * 重新构建message
     *
     * @param source message
     * @param args   参数
     * @return string
     */
    protected static String rebuildMessage(String source, Object... args) {
        if (null != args && args.length > 0) {
            for (Object arg : args) {
                int index = source.indexOf("{}");
                if (index >= 0) {
                    source = source.substring(0, index) + arg.toString() +
                        source.substring(index + 2);
                } else {
                    break;
                }
            }
            return source;
        } else {
            return source;
        }
    }

}
