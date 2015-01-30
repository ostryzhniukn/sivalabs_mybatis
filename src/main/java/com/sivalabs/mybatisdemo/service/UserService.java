package com.sivalabs.mybatisdemo.service;

import com.sivalabs.mybatisdemo.domain.User;
import com.sivalabs.mybatisdemo.mappers.UserMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService
{

    public void insertUser(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.insertUser(user);
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
    }

    public void insertUserWithBlog(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.insertUserWithBlog(user);
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }
    }

    public User getUserById(Integer userId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserById(userId);
        }finally{
            sqlSession.close();
        }
    }

    public List<User> getAllUsers() {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getAllUsers();
        }finally{
            sqlSession.close();
        }
    }

    public void updateUser(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateUser(user);
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }

    }

    public void deleteUser(Integer userId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(userId);
            sqlSession.commit();
        }finally{
            sqlSession.close();
        }

    }

}
