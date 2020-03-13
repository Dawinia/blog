package com.blog.blog.service.serviceImpl;

import com.blog.blog.mapper.UserMapper;
import com.blog.blog.model.entity.User;
import com.blog.blog.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dawinia Lo
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers()
    {
        return userMapper.getAllUsers();
    }

    @Override
    public List<User> getUsersByPage(int page, int size, User user)
    {
        return userMapper.getUsersByPage(page, size, user);
    }

    @Override
    public User getUserById(int id)
    {
        return userMapper.getUserById(id);
    }

    @Override
    public int addUser(User user)
    {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUserById(int id)
    {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int updateUser(User user)
    {
        return userMapper.updateUser(user);
    }

}
