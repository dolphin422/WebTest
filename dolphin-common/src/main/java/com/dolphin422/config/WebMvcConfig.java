package com.dolphin422.config;

import com.dolphin422.common.util.DateUtil;
import com.dolphin422.custom.SpringfoxJsonToGsonAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.json.Json;

/**
 * @Description: 更换SpringBoot默认的Jackson 为GSON
 * @author: DamonJT WIN
 * @createDate: 2018.12.27 17:29
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public HttpMessageConverters customConverters() {
        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        Gson gson = new GsonBuilder()
            //设置时间格式
            .setDateFormat(DateUtil.DEFAULT_FORMAT_DATE_TIME)
            .registerTypeAdapter(Json.class, new SpringfoxJsonToGsonAdapter())
            .create();
        gsonHttpMessageConverter.setGson(gson);
        gsonHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        messageConverters.add(gsonHttpMessageConverter);
        return new HttpMessageConverters(true, messageConverters);
    }

    /**
     * 设置跨域请求
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
            //设置允许跨域请求的域名
            .allowedOrigins("*")
            //是否允许证书 不再默认开启
            .allowCredentials(true)
            //设置允许的方法
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            //跨域允许时间
            .maxAge(3600);
    }
}
