package com.dolphin422.system.dao.user;

import com.dolphin422.system.model.user.SysUserModel;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface ISysUserDao extends Mapper<SysUserModel> {
}
