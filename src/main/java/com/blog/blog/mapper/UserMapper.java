package com.blog.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.blog.model.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Dawinia Lo
 */
@Mapper
public interface UserMapper extends BaseMapper<User>
{
    List<User> getAllUsers();

    List<User> getUsersByPage(@Param("page") int page, @Param("size") int size, @Param("user") User user);

    User getUserById(int id);

    int addUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);
}
