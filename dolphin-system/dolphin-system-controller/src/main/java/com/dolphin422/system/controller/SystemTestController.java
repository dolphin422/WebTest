package com.dolphin422.system.controller;

import com.dolphin422.common.util.UUIDGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: jiatai
 * @CreateDate: 2018.11.23 19:53
 */
@Controller
public class SystemTestController {

    @RequestMapping("/testHello")
    @ResponseBody
    public String sayHello(String name) {

        return "Hello " + name + UUIDGenerator.getUUID();
    }
}
