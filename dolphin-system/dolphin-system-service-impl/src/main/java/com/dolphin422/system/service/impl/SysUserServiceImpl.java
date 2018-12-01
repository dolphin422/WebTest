package com.dolphin422.system.service.impl;

import com.dolphin422.system.dao.ISysUserDao;
import com.dolphin422.system.model.SysUserModel;
import com.dolphin422.system.service.api.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private ISysUserDao userDao;

    public List<SysUserModel> searchListByPage() {

        return userDao.selectAll();
    }
}
