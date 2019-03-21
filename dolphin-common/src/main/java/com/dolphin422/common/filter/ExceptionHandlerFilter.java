package com.dolphin422.common.filter;

import com.dolphin422.common.exception.BusinessException;
import com.dolphin422.common.returnvo.ReturnVo;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @Description:
 * @author: DamonJT WIN
 * @createDate: 2019.03.21 20:28
 */
public class ExceptionHandlerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, FilterChain filterChain)
        throws ServletException, IOException {
        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (BusinessException be) {
            ReturnVo<String> stringReturnVo = ReturnVo.failVo(be.getExceptionCode());
            stringReturnVo.setMessage(be.getMessage());
            httpServletResponse.setStatus(Integer.valueOf(be.getExceptionCode().getStatusCode()));
            Gson gson = new Gson();
            httpServletResponse.getWriter().write(gson.toJson(stringReturnVo));
        }
    }
}
