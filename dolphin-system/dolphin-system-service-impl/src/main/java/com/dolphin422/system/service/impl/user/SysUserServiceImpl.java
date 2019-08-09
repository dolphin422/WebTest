package com.dolphin422.system.service.impl.user;

import com.dolphin422.common.base.BaseServiceImpl;
import com.dolphin422.common.enumeration.statuscode.business.BusinessExceptionEnum;
import com.dolphin422.common.exception.BusinessException;
import com.dolphin422.common.util.DateUtil;
import com.dolphin422.system.dao.user.ISysUserDao;
import com.dolphin422.system.model.user.SysUserModel;
import com.dolphin422.system.service.api.user.ISysUserService;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Resource
    private ISysUserDao userDao;

    @Override
    public String getUserName(String userId) throws BusinessException {
        String currentDateTime = DateUtil.getCurrentDateTime();
        logger.info("--现在时间:{}---实际对象SysUserServiceImpl-传入--({})--", currentDateTime,userId);
        return currentDateTime + ":" + userId;
    }

    @Override
    public List<SysUserModel> searchListByPage() throws BusinessException {
        List<SysUserModel> sysUserModelList = userDao.selectAll();
        SysUserModel sysUserModel = new SysUserModel();
        sysUserModel.setId("3");
        sysUserModel.setGmtCreate(new Date());
        sysUserModelList.add(sysUserModel);
        return sysUserModelList;
    }

    @Override
    public void addUser(SysUserModel sysUserModel) throws BusinessException {
        if (null == sysUserModel) {
            logger.debug("新增用户传入数据为空");
            throw new BusinessException(BusinessExceptionEnum.ARGUMENT_NULL, "新增用户传入数据为空");
        }
        userDao.insert(sysUserModel);
    }

    @Override
    public SysUserModel findUserById(String id) throws BusinessException {
        if (StringUtils.isEmpty(id)) {
            logger.debug("查询用户传入主键Id为空");
            throw new BusinessException(BusinessExceptionEnum.ARGUMENT_NULL, "查询用户传入主键Id为空");
        }

        return null;
        // return userDao.selectByPrimaryKey(id);
    }

    @Override
    public void updateUserFull(SysUserModel sysUserModel) throws BusinessException {
        if (null == sysUserModel) {
            logger.debug("修改用户信息传入数据为空");
            throw new BusinessException(BusinessExceptionEnum.ARGUMENT_NULL, "修改用户信息传入数据为空");
        }
        if (StringUtils.isEmpty(sysUserModel.getId())) {
            logger.debug("修改用户信息传入用户ID为空");
            throw new BusinessException(BusinessExceptionEnum.ARGUMENT_NULL, "修改用户信息传入用户ID为空");
        }
        userDao.updateByPrimaryKey(sysUserModel);
    }

    @Override
    public void deleteUser(String id) throws BusinessException {
        if (StringUtils.isEmpty(id)) {
            logger.debug("删除用户传入主键Id为空");
            throw new BusinessException(BusinessExceptionEnum.ARGUMENT_NULL, "删除用户传入主键Id为空");
        }
        userDao.deleteByPrimaryKey(id);

    }

    @Override
    public void updateUserSelective(SysUserModel sysUserModel) throws BusinessException {
        if (null == sysUserModel) {
            logger.debug("修改用户信息传入数据为空");
            throw new BusinessException(BusinessExceptionEnum.ARGUMENT_NULL, "修改用户信息传入数据为空");
        }
        if (StringUtils.isEmpty(sysUserModel.getId())) {
            logger.debug("修改用户信息传入用户ID为空");
            throw new BusinessException(BusinessExceptionEnum.ARGUMENT_NULL, "修改用户信息传入用户ID为空");
        }
        userDao.updateByPrimaryKeySelective(sysUserModel);
    }
}
