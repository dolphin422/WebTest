package com.dolphin422.config;

import com.dolphin422.common.filter.ContentTypeFilter;
import com.dolphin422.common.filter.ExceptionHandlerFilter;
import com.dolphin422.common.filter.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 过滤器配置类
 * @author: DamonJT MAC
 * @createDate: 2018/12/22 23:21
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean contentTypeFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ContentTypeFilter());
        registration.addUrlPatterns("/*");
        registration.setName("ContentTypeFilter");
        registration.setOrder(2);
        return registration;
    }
    @Bean
    public FilterRegistrationBean xssFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns("/*");
        registration.setName("XssFilter");
        registration.setOrder(3);
        return registration;
    }
    @Bean
    public FilterRegistrationBean exceptionHandlerFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ExceptionHandlerFilter());
        registration.addUrlPatterns("/*");
        registration.setName("exceptionHandlerFilter");
        registration.setOrder(1);
        return registration;
    }
}
