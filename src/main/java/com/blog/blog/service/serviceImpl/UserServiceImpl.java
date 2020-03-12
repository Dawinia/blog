package com.blog.blog.service.serviceImpl;

import com.blog.blog.mapper.UserMapper;
import com.blog.blog.model.entity.User;
import com.blog.blog.service.UserService;
import java.util.List;

/**
 * @author Dawinia Lo
 */
public class UserServiceImpl implements UserService
{
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser()
    {
        return null;
    }

    @Override
    public User getUserById(int id)
    {
        return null;
    }

    @Override
    public int addUser(User user)
    {
        return 0;
    }

    @Override
    public int deleteUserById(int id)
    {
        return 0;
    }

    @Override
    public int updateUser(User user)
    {
        return 0;
    }

}
