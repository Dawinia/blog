package com.blog.blog.api;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.Builder;


/**
 * @author Dawinia Lo
 */
@Builder
public class Result<T>
{
    private int code;

    private String message;

    private T data;
}
