package com.dolphin422.common.filter;

import com.dolphin422.common.enumeration.statuscode.system.SystemExceptionCodeEnum;
import com.dolphin422.common.exception.BusinessException;
import com.dolphin422.common.returnvo.ReturnVo;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @Description: 处理Filter中异常
 * @author: DamonJT WIN
 * @createDate: 2019.03.21 20:28
 */
public class ExceptionHandlerFilter extends OncePerRequestFilter {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, FilterChain filterChain)
        throws IOException {
        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (BusinessException be) {
            ReturnVo<String> stringReturnVo = ReturnVo.failVo(be.getExceptionCode());
            stringReturnVo.setMessage(be.getMessage());
            httpServletResponse.setStatus(Integer.valueOf(be.getExceptionCode().getStatusCode()));
            Gson gson = new Gson();
            httpServletResponse.getWriter().write(gson.toJson(stringReturnVo));
        } catch (Exception ex) {
            ReturnVo<String> stringReturnVo = ReturnVo.failVo(SystemExceptionCodeEnum.ERROR);
            String exName = ex.getClass().getName();
            logger.error("程序异常,信息:{}:{}", exName, ex.getMessage(), ex);
            stringReturnVo.setMessage("程序异常,信息:" + exName);
            httpServletResponse.setStatus(Integer.valueOf(SystemExceptionCodeEnum.ERROR.getStatusCode()));
            Gson gson = new Gson();
            httpServletResponse.getWriter().write(gson.toJson(stringReturnVo));
        }
    }
}
