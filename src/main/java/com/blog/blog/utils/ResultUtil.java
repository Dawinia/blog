package com.blog.blog.utils;

import com.blog.blog.api.Result;
import com.blog.blog.api.ResultCode;

/**
 * @author Dawinia Lo
 */
public class ResultUtil<T>
{

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result success()
    {
        return Result.builder()
                .code(ResultCode.SUCCESS.code)
                .message(DEFAULT_SUCCESS_MESSAGE)
                .build();
    }

    public static Result success(Object data)
    {
        return Result.builder()
                .code(ResultCode.SUCCESS.code)
                .message(DEFAULT_SUCCESS_MESSAGE)
                .data(data)
                .build();
    }

    public static Result error(String message)
    {
        return Result.builder()
                .code(ResultCode.ERROR.code)
                .message(message)
                .build();
    }
}