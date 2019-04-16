package com.dolphin422.system.controller.test;

import com.dolphin422.common.base.BaseController;
import com.dolphin422.common.util.UUIDGenerator;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

        return "Hello " + name + ", Now is " + new Date() + "Your system uuid is " + UUIDGenerator.getUUID();
    }

    @RequestMapping(value = "/{group}/{name}", method = RequestMethod.POST)
    @ResponseBody
    public String testPath(@PathVariable String group, @PathVariable String name) {
        return "Hello group" + group + name + ", Now is " + new Date() + "Your system uuid is " +
            UUIDGenerator.getUUID();
    }

    @RequestMapping(value = "/{abc}/{cd}", method = RequestMethod.POST)
    @ResponseBody
    public String testPath2(@PathVariable String abc, @PathVariable String cd) {

        return "Hello abc " + abc + cd + ", Now is " + new Date() + "Your system uuid is " +
            UUIDGenerator.getUUID();
    }

}
