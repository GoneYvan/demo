package com.company.base;

import com.company.commons.services.UserService;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class ServiceLocator extends CommonServiceLocator{

    public static UserService getUserService(){
        return (UserService)getBean("userService");
    }




}
