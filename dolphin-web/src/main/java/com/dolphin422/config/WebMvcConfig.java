package com.dolphin422.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: WebMvc 配置类
 * @author: DamonJT WIN
 * @createDate: 2018.12.13 20:42
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置消息转换器--这里我用的是alibaba 开源的 fastjson
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1.需要定义一个convert转换消息的对象;
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        //2.添加fastJson的配置信息，比如：是否要格式化返回的json数据;

/*        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
            SerializerFeature.WriteMapNullValue,
            SerializerFeature.WriteNullStringAsEmpty,
            SerializerFeature.DisableCircularReferenceDetect,
            SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteDateUseDateFormat);*/
        //3处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        //4.在convert中添加配置信息.
        gsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        //gsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //5.将convert添加到converters当中.
        converters.add(gsonHttpMessageConverter);
    }

}
