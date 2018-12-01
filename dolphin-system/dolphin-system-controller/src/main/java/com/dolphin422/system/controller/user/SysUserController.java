package com.dolphin422.system.controller.user;

import com.dolphin422.system.model.SysUserModel;
import com.dolphin422.system.service.api.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
        logger.trace("--trace----select start------");
        logger.debug("--debug----select start------");
        logger.info("--info----select start------");
        logger.warn("--warn----select start------");
        logger.error("--error----select start------");
        List<SysUserModel> userModelList = sysUserService.searchListByPage();
        logger.debug("------select end ------");
        return userModelList;
    }
}
