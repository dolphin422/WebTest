package com.dolphin422.business.controller.test;

import com.dolphin422.common.base.BaseController;
import com.dolphin422.common.enumeration.statuscode.business.BusinessExceptionEnum;
import com.dolphin422.common.enumeration.statuscode.system.SystemExceptionEnum;
import com.dolphin422.common.exception.BusinessException;
import com.dolphin422.common.exception.SystemException;
import com.dolphin422.common.util.UUIDGenerator;
import com.dolphin422.common.returnvo.ReturnVo;
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
        return "Hello " + name + ", Your business uuid is " + UUIDGenerator.getUUID();
    }

    @RequestMapping("/1")
    @ResponseBody
    public ReturnVo sayReturnVo1(String name) {
        throw new BusinessException(BusinessExceptionEnum.FAILURE, "BusinessExcep{}tion.600",name);
        //return ReturnVo.successVo(name);
    }

    @RequestMapping("/2")
    @ResponseBody
    public ReturnVo sayReturnVo2(String name) {
        throw new SystemException(SystemExceptionEnum.TIME_OUT, "SystemExceptionCod{}eEnum.701",name);
        //return ReturnVo.successVo(name);
    }

    @RequestMapping("/3")
    @ResponseBody
    public ReturnVo sayReturnVo3(String name) {
        int a = 5;
        int b = Integer.valueOf(name);
        int c = a / b;
        return ReturnVo.successVo(c);

    }

}
