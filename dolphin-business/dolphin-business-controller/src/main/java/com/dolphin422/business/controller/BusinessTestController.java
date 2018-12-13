package com.dolphin422.business.controller;

import com.dolphin422.common.base.BaseController;
import com.dolphin422.common.util.UUIDGenerator;
import com.dolphin422.common.vo.returndata.ReturnVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 业务模块 请求处理层
 * @author: DamonJT
 * @createDate: 2018.11.25 19:11
 */
@Controller
@RequestMapping("/business")
public class BusinessTestController extends BaseController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(String name) {
        return "Hello " + name+", Your business uuid is " + UUIDGenerator.getUUID();
    }


    @RequestMapping("/test")
    @ResponseBody
    public ReturnVo sayReturnVo(String name) {
        return ReturnVo.successVo(name);
    }



}
