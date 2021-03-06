package com.sivalabs.mybatisdemo;

import com.sivalabs.mybatisdemo.domain.Blog;
import com.sivalabs.mybatisdemo.domain.User;
import com.sivalabs.mybatisdemo.service.BlogService;
import com.sivalabs.mybatisdemo.service.UserService;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserServiceTest
{
    private static UserService userService;

    @BeforeClass
    public static void setup()
    {
        userService = new UserService();
    }

    @AfterClass
    public static void teardown()
    {
        userService = null;
    }

    @Test
    public void testGetUserById()
    {
        User user = userService.getUserById(1);
        Assert.assertNotNull(user);
        System.out.println(user);
    }

    @Test
    public void testGetAllUsers()
    {
        List<User> users = userService.getAllUsers();
        Assert.assertNotNull(users);
        for (User user : users)
        {
            System.out.println(user);
        }

    }

    @Test
    public void testInsertUser()
    {
        User user = new User();
        user.setEmailId("test_email_"+System.currentTimeMillis()+"@gmail.com");
        user.setPassword("secret");
        user.setFirstName("TestFirstName");
        user.setLastName("TestLastName");

        userService.insertUser(user);
        Assert.assertTrue(user.getUserId() != 0);
        User createdUser = userService.getUserById(user.getUserId());
        Assert.assertNotNull(createdUser);
        Assert.assertEquals(user.getEmailId(), createdUser.getEmailId());
        Assert.assertEquals(user.getPassword(), createdUser.getPassword());
        Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
        Assert.assertEquals(user.getLastName(), createdUser.getLastName());

    }

    @Test
    public void testInsertUserWithBlog(){
        User user = new User();
        user.setEmailId("test_email_"+System.currentTimeMillis()+"@gmail.com");
        user.setPassword("secret");
        user.setFirstName("TestFirstName");
        user.setLastName("TestLastName");

        Blog blog = new Blog();
        blog.setBlogName("test_blog_"+System.currentTimeMillis());
        blog.setCreatedOn(new Date());
        new BlogService().insertBlog(blog);
        Assert.assertTrue(blog.getBlogId() != 0);

        user.setBlog(blog);

        userService.insertUserWithBlog(user);
        Assert.assertTrue(user.getUserId() != 0);
        User createdUser = userService.getUserById(user.getUserId());
        Assert.assertNotNull(createdUser);
        Assert.assertEquals(user.getEmailId(), createdUser.getEmailId());
        Assert.assertEquals(user.getPassword(), createdUser.getPassword());
        Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
        Assert.assertEquals(user.getLastName(), createdUser.getLastName());

        Assert.assertNotNull(createdUser.getBlog());
        Assert.assertEquals(blog.getBlogName(), createdUser.getBlog().getBlogName());


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

    @Test
    public void testDeleteUser()
    {
        User user = userService.getUserById(4);
        userService.deleteUser(user.getUserId());
        User deletedUser = userService.getUserById(4);
        Assert.assertNull(deletedUser);

    }
}