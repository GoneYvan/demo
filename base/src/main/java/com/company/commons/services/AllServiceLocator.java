package com.company.commons.services;

import com.company.base.ServiceLocator;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class AllServiceLocator extends ServiceLocator {

    public static UserService getUserService(){
        return (UserService)getBean("userService");
    }




}
