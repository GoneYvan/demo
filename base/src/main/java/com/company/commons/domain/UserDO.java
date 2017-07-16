package com.company.commons.domain;

import com.company.base.BaseDO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public class UserDO extends BaseDO implements Serializable{

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
