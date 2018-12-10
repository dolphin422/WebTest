package com.dolphin422.system.service.api.user;

import com.dolphin422.system.model.user.SysUserModel;

import java.util.List;
/**
* @description: 用户管理接口
* @author:  DamonJT
* @createDate:  2018.12.08 18:54
*/
public interface ISysUserService {
    /**
     *
     * @return
     */
    List<SysUserModel> searchListByPage();
}
