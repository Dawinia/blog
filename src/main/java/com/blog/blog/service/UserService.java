package com.blog.blog.service;

import com.blog.blog.model.entity.User;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Dawinia Lo
 */
@Service
public interface UserService
{
    List<User> getAllUsers();

    List<User> getUsersByPage(int page, int size, User user);

    User getUserById(int id);

    int addUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);
}
