package com.sivalabs.mybatisdemo;

import com.sivalabs.mybatisdemo.domain.User;
import com.sivalabs.mybatisdemo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:mybatis-config.xml")
public class SpringUserServiceTest
{
    @Autowired
    private UserService userService;

    @Test
    public void testGetUserById()
    {
        User user = userService.getUserById(1);
        Assert.assertNotNull(user);
        System.out.println(user);
        System.out.println(user.getBlog());
    }

    @Test
    public void testUpdateUser()
    {
        long timestamp = System.currentTimeMillis();
        User user = userService.getUserById(2);
        user.setFirstName("TestFirstName"+timestamp);
        user.setLastName("TestLastName"+timestamp);
        userService.updateUser(user);
        User updatedUser = userService.getUserById(2);
        Assert.assertEquals(user.getFirstName(), updatedUser.getFirstName());
        Assert.assertEquals(user.getLastName(), updatedUser.getLastName());
    }

}
