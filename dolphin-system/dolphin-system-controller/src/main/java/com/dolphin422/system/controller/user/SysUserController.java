package com.dolphin422.system.controller.user;


import com.dolphin422.system.model.SysUserModel;
import com.dolphin422.system.service.api.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;


    @RequestMapping("/showDataByPage")
    @ResponseBody
    public List<SysUserModel> showDataByPage() {

        List<SysUserModel> userModelList = sysUserService.searchListByPage();
        return userModelList;
    }
}
