package com.dolphin422.system.controller;

import com.dolphin422.common.base.BaseController;
import com.dolphin422.common.util.UUIDGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Description: 系统模块 请求处理层
 * @Author: DamonJT
 * @CreateDate: 2018.11.23 19:53
 */
@Controller
@RequestMapping("/system")
public class SystemTestController extends BaseController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(String name) {

        return "Hello " + name+", Now is "+new Date()+"Your system uuid is " + UUIDGenerator.getUUID();
    }

}
