package com.dolphin422.system.service.impl.user;

import com.dolphin422.common.base.BaseServiceImpl;
import com.dolphin422.common.enumeration.statuscode.business.BusinessStatusCodeEnum;
import com.dolphin422.common.exception.BusinessException;
import com.dolphin422.system.dao.user.ISysUserDao;
import com.dolphin422.system.model.user.SysUserModel;
import com.dolphin422.system.service.api.user.ISysUserService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 用户管理实现类
 * @author: DamonJT
 * @createDate: 2018.12.08 18:54
 */
@Service
@Transactional
public class SysUserServiceImpl extends BaseServiceImpl implements ISysUserService {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private ISysUserDao userDao;

    @Override
    public List<SysUserModel> searchListByPage() throws BusinessException {
        return userDao.selectAll();
    }

    @Override
    public void addUser(SysUserModel sysUserModel) throws BusinessException {
        if (null == sysUserModel) {
            logger.debug("新增用户传入数据为空");
            throw new BusinessException(BusinessStatusCodeEnum.ARGUEMENT_NULL, "新增用户传入数据为空");
        }
        userDao.insert(sysUserModel);
    }

    @Override
    public SysUserModel findUserById(String id) throws BusinessException {
        if (StringUtils.isEmpty(id)) {
            logger.debug("查询用户传入主键Id为空");
            throw new BusinessException(BusinessStatusCodeEnum.ARGUEMENT_NULL, "查询用户传入主键Id为空");
        }
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public void updateUserFull(SysUserModel sysUserModel) throws BusinessException {
        if (null == sysUserModel) {
            logger.debug("修改用户信息传入数据为空");
            throw new BusinessException(BusinessStatusCodeEnum.ARGUEMENT_NULL, "修改用户信息传入数据为空");
        }
        if (StringUtils.isEmpty(sysUserModel.getId())) {
            logger.debug("修改用户信息传入用户ID为空");
            throw new BusinessException(BusinessStatusCodeEnum.ARGUEMENT_NULL, "修改用户信息传入用户ID为空");
        }
        userDao.updateByPrimaryKey(sysUserModel);
    }

    @Override
    public void deleteUser(String id) throws BusinessException {
        if (StringUtils.isEmpty(id)) {
            logger.debug("删除用户传入主键Id为空");
            throw new BusinessException(BusinessStatusCodeEnum.ARGUEMENT_NULL, "删除用户传入主键Id为空");
        }
        userDao.deleteByPrimaryKey(id);

    }

    @Override
    public void updateUserSelective(SysUserModel sysUserModel) throws BusinessException {
        if (null == sysUserModel) {
            logger.debug("修改用户信息传入数据为空");
            throw new BusinessException(BusinessStatusCodeEnum.ARGUEMENT_NULL, "修改用户信息传入数据为空");
        }
        if (StringUtils.isEmpty(sysUserModel.getId())) {
            logger.debug("修改用户信息传入用户ID为空");
            throw new BusinessException(BusinessStatusCodeEnum.ARGUEMENT_NULL, "修改用户信息传入用户ID为空");
        }
        userDao.updateByPrimaryKeySelective(sysUserModel);
    }
}
