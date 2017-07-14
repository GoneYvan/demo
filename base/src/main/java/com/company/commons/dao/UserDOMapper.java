package com.company.commons.dao;


import com.company.commons.domain.UserDO;

public interface UserDOMapper {

    Boolean deleteById(Integer id);

    Integer create(UserDO record);

    UserDO getById(Integer id);

    Boolean updateById(UserDO record);
}