package com.blog.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blog.model.entity.User;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Dawinia Lo
 */
@Service
public interface UserService
{
    public final static Logger logger = LoggerFactory.getLogger(UserService.class);

    List<User> getAllUsers();

    Page<User> getUsersByPage(int page, int size, User user);

    User getUserById(int id);

    int addUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);
}
