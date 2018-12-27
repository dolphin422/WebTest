package com.dolphin422.config;

import com.dolphin422.common.util.DateUtil;
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

/**
 * @Description: 更换SpringBoot默认的Jackson 为GSON
 * @author: DamonJT WIN
 * @createDate: 2018.12.27 17:29
 */
@Configuration
public class WebMvcConfig {

    @Bean
    public HttpMessageConverters customConverters() {
        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        gsonHttpMessageConverter.setGson(new GsonBuilder().setDateFormat(DateUtil.FORMAT_DATE_TIME).create());
        gsonHttpMessageConverter.setSupportedMediaTypes(Arrays
            .asList(MediaType.APPLICATION_JSON));
        messageConverters.add(gsonHttpMessageConverter);
        return new HttpMessageConverters(true, messageConverters);
    }
}
