package com.blog.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.sql.Timestamp;
import lombok.Data;

/**
 * @author Dawinia Lo
 */
@Data
@TableName("article")
public class Article
{
    @TableId(type = IdType.AUTO)
    private int id;

    private String content;

    @TableField("create_date")
    private Timestamp createDate;

    @TableField("modify_date")
    private Timestamp modifyDate;

    @TableField("uid")
    private int author;

    private String title;

}
