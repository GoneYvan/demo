package com.company.commons.dao.impl;

import com.company.commons.dao.UserDOMapper;
import com.company.commons.domain.UserDO;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public class UserDOMapperImpl extends SqlSessionDaoSupport implements UserDOMapper {

    private final static String namespace = "com.company.commons.dao.UserDOMapper.";

    @Override
    public Boolean deleteById(Integer id) {
        return getSqlSession().delete(namespace + "deleteById", id)==0?false:true;
    }

    @Override
    public Integer create(UserDO record) {
        return getSqlSession().insert(namespace + "create", record);
    }

    @Override
    public UserDO getById(Integer id) {
        return (UserDO) getSqlSession().selectOne(namespace + "getById", id);
    }

    @Override
    public Boolean updateById(UserDO record) {
        return getSqlSession().update(namespace + "create", record)>0?true:false;
    }
}
