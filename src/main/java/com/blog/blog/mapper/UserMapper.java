package com.blog.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.blog.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Dawinia Lo
 */
@Mapper
public interface UserMapper extends BaseMapper<User>
{

}
