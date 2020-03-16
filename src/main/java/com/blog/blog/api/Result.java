package com.blog.blog.api;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.Builder;
import lombok.Data;


/**
 * @author Dawinia Lo
 */
@Builder
@Data
public class Result<T>
{
    private int code;

    private String message;

    private T data;
}
