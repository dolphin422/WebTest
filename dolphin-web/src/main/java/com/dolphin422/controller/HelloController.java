package com.dolphin422.controller;

import com.dolphin422.common.util.UUIDGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: web 请求处理模块
 * @author: DamonJT
 * @CreateDate: 2018.11.17 17:25
 */
@Controller
@RequestMapping("/web")
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(String name) {

        return "Hello " + name + ", Your web uuid is " + UUIDGenerator.getUUID();
    }
}
