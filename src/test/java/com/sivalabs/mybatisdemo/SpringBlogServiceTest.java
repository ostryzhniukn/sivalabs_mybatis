package com.sivalabs.mybatisdemo;

import com.sivalabs.mybatisdemo.domain.Blog;
import com.sivalabs.mybatisdemo.domain.Post;
import com.sivalabs.mybatisdemo.service.BlogService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:mybatis-config.xml")
public class SpringBlogServiceTest
{
    @Autowired
    private BlogService blogService;

    @Test
    public void testGetBlogById()
    {
        Blog blog = blogService.getBlogById(1);
        Assert.assertNotNull(blog);
        System.out.println(blog);
        List<Post> posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    public void testInsertBlog()
    {
        Blog blog = new Blog();
        blog.setBlogName("test_blog_"+System.currentTimeMillis());
        blog.setCreatedOn(new Date());

        blogService.insertBlog(blog);
        Assert.assertTrue(blog.getBlogId() != 0);
        Blog createdBlog = blogService.getBlogById(blog.getBlogId());
        Assert.assertNotNull(createdBlog);
        Assert.assertEquals(blog.getBlogName(), createdBlog.getBlogName());

    }

}
