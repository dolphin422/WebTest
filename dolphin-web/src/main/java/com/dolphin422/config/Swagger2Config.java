package com.dolphin422.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: swagger2 配置类
 * @author: DamonJT WIN
 * @createDate: 2018.12.21 12:24
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.dolphin422.system.restcontroller"))
            .paths(PathSelectors.any())
            .build();
    }

    /**
     * API文档信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("利用Swagger2构建Api文档")
            .description("dolphin项目rest接口文档")
            .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
            .version("1.0")
            .build();
    }
}
