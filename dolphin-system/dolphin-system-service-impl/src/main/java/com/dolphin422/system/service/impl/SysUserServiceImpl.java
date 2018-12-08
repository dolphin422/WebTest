package com.dolphin422.system.service.impl;

import com.dolphin422.system.dao.ISysUserDao;
import com.dolphin422.system.model.SysUserModel;
import com.dolphin422.system.service.api.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
* @description: 用户管理实现类
* @author:  DamonJT
* @createDate:  2018.12.08 18:54
*/
@Service
@Transactional
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private ISysUserDao userDao;

    public List<SysUserModel> searchListByPage() {

        return userDao.selectAll();
    }
}
