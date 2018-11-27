package com.dolphin422.common.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description:  Dao层共用基类
 * @author: DamonJT
 * @createDate: 2018.11.27 17:02
 */
public interface IBaseDao<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
