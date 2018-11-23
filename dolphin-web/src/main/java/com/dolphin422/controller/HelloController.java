package com.dolphin422.controller;

import com.dolphin422.common.util.UUIDGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: jiatai
 * @CreateDate: 2018.11.17 17:25
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(String name) {

        return "Hello " + name + UUIDGenerator.getUUID();
    }
}
