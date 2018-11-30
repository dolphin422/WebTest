package com.dolphin422.system.controller.user;

import com.dolphin422.system.model.SysUserModel;
import com.dolphin422.system.service.api.ISysUserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class SysUserController {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private ISysUserService sysUserService;


    @RequestMapping("/showDataByPage")
    @ResponseBody
    public List<SysUserModel> showDataByPage() {
        logger.debug("------select start------");
        List<SysUserModel> userModelList = sysUserService.searchListByPage();
        logger.debug("------select end ------");
        return userModelList;
    }
}
