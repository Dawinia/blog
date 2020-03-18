package com.blog.blog.service.serviceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blog.mapper.UserMapper;
import com.blog.blog.model.entity.User;
import com.blog.blog.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public Page<User> getUsersByPage(int page, int size, User user)
    {
        page = (page - 1) * size;
        Page<User> userPage = new Page<>(page, size);
        List<User> users = userMapper.getUsersByPage(page, size, user);
        if (users.isEmpty())
        {
            return null;
        }
        userPage.setRecords(users);
        userPage.setTotal(userMapper.getTotal());
        return userPage;
    }

    @Override
    public User getUserById(int id)
    {
        return userMapper.getUserById(id);
    }

    @Override
    public int addUser(User user)
    {
        encryptPassword(user);
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
        encryptPassword(user);
        return userMapper.updateUser(user);
    }

    private void encryptPassword(User user) {
        String password = user.getPassword();
        user.setPassword(new BCryptPasswordEncoder().encode(password));
    }

}
