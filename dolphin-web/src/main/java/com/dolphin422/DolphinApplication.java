package com.dolphin422;

import cn.chaconne.credit.service.SDKServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@ServletComponentScan(value = "com.dolphin422")
@MapperScan(basePackages = {"com.dolphin422.system.dao", "com.dolphin422.business.dao"})
public class DolphinApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        //TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(DolphinApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DolphinApplication.class);
    }
    public DolphinApplication() throws Exception {
        super();

       SDKServiceImpl.config("/Users/djt/iWork/IdeaProjects/cdms4.4/cdms-web/src/main/resources/application.yml",
            "/Users/djt/iWork/IdeaProjects/cdms4.4/cdms-web/src/main/resources/config/bcSDK/DB.xml");
    }

}
