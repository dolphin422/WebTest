package com.dolphin422.common.filter;

import com.dolphin422.common.enumeration.statuscode.system.SystemExceptionEnum;
import com.dolphin422.common.exception.BusinessException;
import com.dolphin422.common.returnvo.ReturnVo;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
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
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        FilterChain filterChain) throws IOException {
        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (BusinessException be) {
            ReturnVo<String> stringReturnVo = ReturnVo.failVo(be.getExceptionCode());
            stringReturnVo.setMessage(be.getMessage());
            httpServletResponse.setStatus(Integer.parseInt(be.getExceptionCode().getStatusCode()));
            httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
            httpServletResponse.setCharacterEncoding("UTF-8");
            Gson gson = new Gson();
            httpServletResponse.getWriter().write(gson.toJson(stringReturnVo));
        } catch (ServletException gb) {
            Throwable cause = gb.getCause();
            ReturnVo<String> stringReturnVo = ReturnVo.failVo(SystemExceptionEnum.ERROR);
            stringReturnVo.setMessage("操作失败,请联系系统管理员");
            if (cause instanceof BusinessException) {
                BusinessException ge = (BusinessException) cause;
                stringReturnVo = ReturnVo.failVo(ge.getExceptionCode());
                stringReturnVo.setMessage(ge.getMessage());
            }
            httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
            httpServletResponse.setCharacterEncoding("UTF-8");
            Gson gson = new Gson();
            httpServletResponse.getWriter().write(gson.toJson(stringReturnVo));
        } catch (Exception ex) {
            ReturnVo<String> stringReturnVo = ReturnVo.failVo(SystemExceptionEnum.ERROR);
            String exName = ex.getClass().getName();
            logger.error("程序异常,信息:{}:{}", exName, ex.getMessage(), ex);
            stringReturnVo.setMessage("程序异常,信息:" + exName);
            httpServletResponse.setStatus(Integer.parseInt(SystemExceptionEnum.ERROR.getStatusCode()));
            httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
            httpServletResponse.setCharacterEncoding("UTF-8");
            Gson gson = new Gson();
            httpServletResponse.getWriter().write(gson.toJson(stringReturnVo));
        }
    }
}
