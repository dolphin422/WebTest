package com.dolphin422;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ServletComponentScan(value = "com.dolphin422")
@MapperScan(basePackages = {"com.dolphin422.system.dao"})
public class DolphinApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DolphinApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DolphinApplication.class);
    }


}