package com.sivalabs.mybatisdemo.service;

import com.sivalabs.mybatisdemo.domain.User;
import com.sivalabs.mybatisdemo.mappers.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private SqlSession sqlSession; //This is to demonstrate injecting SqlSession object

    public void insertUser(User user) {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insertUser(user);
    }

    public User getUserById(Integer userId) {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getUserById(userId);
    }

    public void updateUser(User user){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(user);
    }

}
