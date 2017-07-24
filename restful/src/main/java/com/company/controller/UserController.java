package com.company.controller;

import com.company.base.ApplicationLogger;
import com.company.base.JsonResponse;
import com.company.base.JsonResponseUtil;
import com.company.commons.services.AllServiceLocator;
import com.company.commons.domain.UserDO;
import com.company.commons.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService = AllServiceLocator.getUserService();

    @RequestMapping("/add")
    public JsonResponse createUser(UserDO userDO){
        Integer id = userService.createUser(userDO);
        if(id != null && id > 0){
            return JsonResponseUtil.success(id);
        }else{
            return JsonResponseUtil.fail();
        }
    }

    @RequestMapping("/get")
    public JsonResponse getById(Integer id){
        UserDO userDO = userService.getById(id);
        if(userDO != null && userDO.getId() > 0){
            return JsonResponseUtil.success(userDO);
        }else{
            return JsonResponseUtil.fail();
        }
    }

    @RequestMapping("/update")
    public JsonResponse update(UserDO userDO){
        if(userService.update(userDO)){
            return JsonResponseUtil.success(null);
        }else{
            return JsonResponseUtil.fail();
        }
    }

    @RequestMapping("/delete")
    public JsonResponse deleteById(Integer id){
        if(userService.deleteById(id)){
            return JsonResponseUtil.success(null);
        }else{
            return JsonResponseUtil.fail();
        }
    }

    /**
     * test origin
     * @param userDO
     * @return
     */
    @RequestMapping("/update1")
    public JsonResponse update1(UserDO userDO){
        if(userService.update(userDO)){
            return JsonResponseUtil.success(null);
        }else{
            return JsonResponseUtil.fail();
        }
    }


}
