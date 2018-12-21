package com.dolphin422.system.service.api.user;

import com.dolphin422.common.exception.BusinessException;
import com.dolphin422.system.model.user.SysUserModel;
import java.util.List;

/**
 * @description: 用户管理接口
 * @author: DamonJT
 * @createDate: 2018.12.08 18:54
 */
public interface ISysUserService {
    /**
     * 分页查询
     *
     * @return 列表
     * @throws BusinessException
     */
    List<SysUserModel> searchListByPage() throws BusinessException;

    /**
     * 新增用户
     *
     * @param sysUserModel 用户MODEL
     * @return
     * @throws BusinessException
     */
    void addUser(SysUserModel sysUserModel) throws BusinessException;

    /**
     * 根据ID查询记录
     *
     * @param id 主键ID
     * @return 用户记录
     * @throws BusinessException 业务异常
     */
    SysUserModel findUserById(String id) throws BusinessException;

    /**
     * 更新用户 全量更新
     *
     * @param sysUserModel 用户信息
     * @return
     * @throws BusinessException
     */
    void updateUserFull(SysUserModel sysUserModel) throws BusinessException;

    /**
     * 删除用户
     *
     * @param id 主键ID
     * @return
     * @throws BusinessException
     */
    void deleteUser(String id) throws BusinessException;

    /**
     * 更新用户  选择性更新
     *
     * @param sysUserModel 用户信息
     * @return
     * @throws BusinessException
     */
    void updateUserSelective(SysUserModel sysUserModel) throws BusinessException;
}
