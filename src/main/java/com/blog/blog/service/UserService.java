package com.blog.blog.service;

import com.blog.blog.model.entity.User;
import java.util.List;

/**
 * @author Dawinia Lo
 */
public interface UserService
{
    List<User> getAllUser();

    User getUserById(int id);

    int addUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);
}
