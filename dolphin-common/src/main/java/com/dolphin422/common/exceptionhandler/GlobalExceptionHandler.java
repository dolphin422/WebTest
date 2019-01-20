package com.dolphin422.common.exceptionhandler;

import com.dolphin422.common.enumeration.statuscode.system.SystemExceptionCodeEnum;
import com.dolphin422.common.exception.BusinessException;
import com.dolphin422.common.exception.SystemException;
import com.dolphin422.common.returnvo.ReturnVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 全局异常处理类
 * @author: DamonJT WIN
 * @createDate: 2018.12.13 22:07
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ReturnVo businessExceptionHandler(BusinessException be) {
        logger.info("业务异常信息:{}", be.getMessage(), be);
        ReturnVo<String> stringReturnVo = ReturnVo.failVo(be.getExceptionCode());
        stringReturnVo.setMessage(be.getMessage());
        return stringReturnVo;
    }

    @ResponseBody
    @ExceptionHandler(value = SystemException.class)
    public ReturnVo systemExceptionHandler(SystemException se) {
        logger.info("系统异常信息:{}", se.getMessage(), se);
        ReturnVo<String> stringReturnVo = ReturnVo.failVo(se.getExceptionCode());
        stringReturnVo.setMessage(se.getMessage());
        return stringReturnVo;
    }

    @ResponseBody
    @ExceptionHandler(value = { Error.class, Exception.class, Throwable.class })
    public ReturnVo errorHandler(Throwable ex) {
        String exName = ex.getClass().getName();
        logger.error("程序异常信息:{}:{}", exName, ex.getMessage(), ex);
        ReturnVo<String> stringReturnVo = ReturnVo.failVo(SystemExceptionCodeEnum.ERROR);
        stringReturnVo.setMessage(exName + ":" + ex.getMessage());
        return stringReturnVo;
    }
}
