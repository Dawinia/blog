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
@TableName("comment")
public class Comment
{
    @TableId(type = IdType.AUTO)
    private int id;

    private String content;

    @TableField("publish_date")
    private Timestamp publishDate;

    @TableField("uid")
    private int owner;

    @TableField("aid")
    private int article;
}
