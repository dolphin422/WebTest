package com.dolphin422.common.base;

import com.google.gson.Gson;
import org.springframework.util.StringUtils;

/**
 * @Description: 自定义异常类基类
 * @author: DamonJT WIN
 * @createDate: 2018.12.11 0:11
 */
public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = -2931700230560392933L;

    /**
     * 异常说明
     */
    protected Enum<? extends IBaseStatusCodeEnum> exceptionCode;

    /**
     * 构造函数
     *
     * @param exceptionCode exceptionCode
     */
    protected BaseException(Enum<? extends IBaseStatusCodeEnum> exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    /**
     * 构造函数
     *
     * @param exceptionCode exceptionCode
     * @param throwable     the throwable
     */
    protected BaseException(Enum<? extends IBaseStatusCodeEnum> exceptionCode,
        Throwable throwable) {
        super(throwable);
        this.exceptionCode = exceptionCode;
    }

    /**
     * 构造函数
     *
     * @param exceptionCode exceptionCode
     * @param message       the message
     */
    protected BaseException(Enum<? extends IBaseStatusCodeEnum> exceptionCode,
        String message) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    /**
     * 构造函数
     *
     * @param exceptionCode exceptionCode
     * @param message       the message
     * @param args          the args
     */
    protected BaseException(Enum<? extends IBaseStatusCodeEnum> exceptionCode,
        String message, Object... args) {
        super(rebuildMessage(message, args));
        this.exceptionCode = exceptionCode;
    }

    /**
     * 构造函数
     *
     * @param exceptionCode exceptionCode
     * @param throwable     the throwable
     * @param message       the message
     */
    protected BaseException(Enum<? extends IBaseStatusCodeEnum> exceptionCode,
        Throwable throwable, String message) {
        super(message, throwable);
        this.exceptionCode = exceptionCode;
    }

    /**
     * 构造函数
     *
     * @param exceptionCode exceptionCode
     * @param throwable     the throwable
     * @param message       the message
     * @param args          the args
     */
    protected BaseException(Enum<? extends IBaseStatusCodeEnum> exceptionCode,
        Throwable throwable, String message, Object... args) {
        super(rebuildMessage(message, args), throwable);
        this.exceptionCode = exceptionCode;
    }

    /**
     * @return exceptionCode
     */
    protected abstract Enum<? extends IBaseStatusCodeEnum> getExceptionCode();

    /**
     * @param exceptionCode exceptionCode
     */
    public void setExceptionCode(Enum<? extends IBaseStatusCodeEnum> exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    /**
     * @return the string
     */
    @Override
    public String toString() {
        return super.toString() + "--异常" + exceptionCode + "--";
    }

    public String getJson() {
        Gson gson = new Gson();
        if (this != null) {
            return gson.toJson(this);
        }
        return null;
    }

    /**
     * 重新构建message
     *
     * @param sourceMsg message
     * @param args      参数
     * @return string
     */
    private static String rebuildMessage(String sourceMsg, Object... args) {
        if (StringUtils.isEmpty(sourceMsg)) {
            return null;
        }
        if (null != args && args.length > 0) {
            for (Object arg : args) {
                int index = sourceMsg.indexOf("{}");
                if (index >= 0) {
                    sourceMsg = sourceMsg.substring(0, index) + arg.toString() +
                        sourceMsg.substring(index + 2);
                } else {
                    break;
                }
            }
        }
        return sourceMsg;
    }

}
