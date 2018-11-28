package com.dolphin422.system.controller;

import com.dolphin422.common.util.UUIDGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 系统模块 请求处理层
 * @Author: DamonJT
 * @CreateDate: 2018.11.23 19:53
 */
@Controller
@RequestMapping("/system")
public class SystemTestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(String name) {

        return "Hello " + name+", Your system uuid is " + UUIDGenerator.getUUID();
    }
}
