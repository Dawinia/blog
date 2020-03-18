package com.blog.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Dawinia Lo
 */
@Data
@TableName("category")
public class Category
{
    @TableId(type = IdType.AUTO)
    private int id;

    private String name;
}
