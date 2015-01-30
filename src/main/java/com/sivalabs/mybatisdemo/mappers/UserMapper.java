package com.sivalabs.mybatisdemo.mappers;

import com.sivalabs.mybatisdemo.domain.User;

import java.util.List;

public interface UserMapper
{

    public void insertUser(User user);

    public void insertUserWithBlog(User user);

    public User getUserById(Integer userId);

    public List<User> getAllUsers();

    public void updateUser(User user);

    public void deleteUser(Integer userId);

}

