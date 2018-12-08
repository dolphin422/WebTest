package com.dolphin422.system.service.api;

import com.dolphin422.system.model.SysUserModel;

import java.util.List;
/**
* @description: 用户管理接口
* @author:  DamonJT
* @createDate:  2018.12.08 18:54
*/
public interface ISysUserService {
    /**
     * 分页查询用户
     * @return
     */
    List<SysUserModel> searchListByPage();
}
