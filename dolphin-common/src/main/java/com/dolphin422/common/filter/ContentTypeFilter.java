package com.dolphin422.common.filter;

import com.dolphin422.common.enumeration.statuscode.business.BusinessStatusCodeEnum;
import com.dolphin422.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: ContentType类型限制Filter
 * @author: DamonJT MAC
 * @createDate: 2018/12/23 09:46
 */
public class ContentTypeFilter extends HttpServlet implements Filter {

    private static final long serialVersionUID = -3907319234295414657L;
    private Logger logger = LoggerFactory.getLogger(ContentTypeFilter.class);


    @Override
    public void doFilter(ServletRequest requestArg0, ServletResponse responseArg1,
                         FilterChain arg2) throws IOException, ServletException {
        String contentType = "content-type";
        HttpServletRequest request = (HttpServletRequest) requestArg0;
        HttpServletResponse response = (HttpServletResponse) responseArg1;
        //判断 ContentType
        String requestContentType = request.getHeader(contentType);
        this.checkContentType(requestContentType);
        arg2.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    /**
     * 判断上传请求的 ContentType
     * 根据项目实际需要增删
     *
     * @param contentType
     * @throws BusinessException
     */
    private void checkContentType(String contentType) throws BusinessException {

        String wwwUrlEncode = "application/x-www-form-urlencoded";
        String mulData = "multipart/form-data";
        String txtPla = "text/plain";
        String json = "application/json";
        String textXml ="text/xml";
        //String utf8 = "charset=utf-8";

        if (StringUtils.isEmpty(contentType)) {
            return;
        }
        contentType = contentType.toLowerCase();
//        if(!contentType.contains(utf8)){
//            logger.debug("http请求ContentType:{}中未设置请求编码格式为utf-8", contentType);
//            throw new BusinessException(BusinessStatusCodeEnum.ILLEGAL_ARGUMENT, "请在http请求ContentType:{}中设置编码格式为utf-8，(charset=utf-8)",
//                    contentType);
//        }
        if (contentType.contains(wwwUrlEncode)) {
            return;
        }
        if (contentType.contains(mulData)) {
            return;
        }
        if (contentType.contains(txtPla)) {
            return;
        }
        if (contentType.contains(json)) {
            return;
        }
        logger.debug("http请求ContentType:{}不符合规则", contentType);
        throw new BusinessException(BusinessStatusCodeEnum.ILLEGAL_ARGUMENT, "http请求ContentType:{}不符合规则,请检查.",
                contentType);

    }

}
