package com.dolphin422.system.controller.user;

import com.dolphin422.common.base.BaseController;
import com.dolphin422.common.returnvo.ReturnVo;
import com.dolphin422.system.model.user.SysUserModel;
import com.dolphin422.system.service.api.user.ISysUserService;
import com.dolphin422.system.vo.jsontest.JsonTestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: 用户管理Controller层
 * @author: DamonJT
 * @createDate: 2018.12.08 19:39
 */
@Controller
@RequestMapping("/user")
public class SysUserController extends BaseController {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("/showDataByPage")
    @ResponseBody
    public List<SysUserModel> showDataByPage() {
        List<SysUserModel> userModelList = sysUserService.searchListByPage();
        return userModelList;
    }

    @RequestMapping("/test")
    @ResponseBody
    public JsonTestVo testJson1(String name) {
        JsonTestVo jsonTestVo = new JsonTestVo();
        jsonTestVo.setCode(name);
        return jsonTestVo;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public ReturnVo testJson2() {
        JsonTestVo jsonTestVo = new JsonTestVo();
        ReturnVo returnVo = ReturnVo.successVo(jsonTestVo);
        return returnVo;
    }

    @RequestMapping("/test3")
    @ResponseBody
    public ReturnVo testJson3() {
        JsonTestVo jsonTestVo = new JsonTestVo();
        ReturnVo returnVo = ReturnVo.successVoWithOriginalData(jsonTestVo);
        return returnVo;
    }

    @RequestMapping("/list")
    @ResponseBody
    public ReturnVo showUserList() {
        List<SysUserModel> userModelList = sysUserService.searchListByPage();
        return ReturnVo.successVoWithOriginalData(userModelList);
    }

}
