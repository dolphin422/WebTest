package com.dolphin422.system.service.api;

import com.dolphin422.system.model.SysUserModel;

import java.util.List;

public interface ISysUserService {
    /**
     *
     * @return
     */
    List<SysUserModel> searchListByPage();
}
