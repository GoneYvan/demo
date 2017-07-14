package com.company.commons;


import com.company.baseTest.BaseTest;
import com.company.commons.dao.UserDOMapper;
import com.company.commons.domain.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/6/28 0028.
 */

@ContextConfiguration(locations = "/META-INF/spring/service/spring_user_service.xml")
@Transactional
public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDOMapper userDOMapper;

    private static final String name = "zhang三1";

    @Test
    public void test(){
        UserDO userDO = new UserDO();
        userDO.setName(name);
        userDOMapper.create(userDO);
        Assert.assertNotNull(userDO.getId());

        userDO = userDOMapper.getById(userDO.getId());
        Assert.assertNotNull(userDO.getCreateAt());

        userDO.setAge(20);
        userDOMapper.updateById(userDO);
        userDO = userDOMapper.getById(userDO.getId());
        Assert.assertNotNull(userDO.getAge());
        Assert.assertEquals(userDO.getAge(), Integer.valueOf(20));

        boolean flag = userDOMapper.deleteById(userDO.getId());
        Assert.assertTrue(flag);

    }
}
