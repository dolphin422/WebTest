package com.dolphin422.system.service.api;

import com.dolphin422.system.model.SysUserModel;

import java.util.List;

public interface ISysUserService {
    /**
     * 分页查询用户
     * @return
     */
    List<SysUserModel> searchListByPage();
}
