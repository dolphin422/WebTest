package com.dolphin422;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//@ServletComponentScan(value = "com.dolphin422")
public class DolphinApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DolphinApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DolphinApplication.class);
    }

}
