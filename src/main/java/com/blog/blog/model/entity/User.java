package com.blog.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Date;
import lombok.Data;

/**
 * @author Dawinia Lo
 */
@Data
@TableName("user")
public class User
{
    @TableId(type = IdType.AUTO)
    private int id;

    private String username;

    private String password;

    private String email;

    @TableField("register_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registerDate;
}
