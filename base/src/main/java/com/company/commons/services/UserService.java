package com.company.commons.services;

import com.company.commons.dao.UserDOMapper;
import com.company.commons.dao.impl.UserDOMapperImpl;
import com.company.commons.domain.UserDO;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public class UserService {

    private UserDOMapper userDOMapper;

    public void setUserDOMapper(UserDOMapperImpl userDOMapper) {
        this.userDOMapper = userDOMapper;
    }

    /**
     * 添加一个新的用户
     * @param userDO
     * @return
     */
    public Integer createUser(UserDO userDO){
        return userDOMapper.create(userDO);
    }

    /**
     * 根据ID获取信息
     * @param id
     * @return
     */
    public UserDO getById(Integer id){
        return userDOMapper.getById(id);
    }

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    public Boolean deleteById(Integer id){
        if(id == null){
            return false;
        }else{
            return userDOMapper.deleteById(id);
        }
    }

    /**
     * 根据ID修改用户信息
     * @param userDO
     * @return
     */
    public Boolean update(UserDO userDO){
        if(userDO.getId() == null){
            return false;
        }else{
            return userDOMapper.updateById(userDO);
        }
    }

}
