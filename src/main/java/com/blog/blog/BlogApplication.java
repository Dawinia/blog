package com.blog.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Dawinia Lo
 */
@SpringBootApplication
@MapperScan("com.blog.blog.mapper")
@EnableAutoConfiguration(exclude = {
org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class BlogApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BlogApplication.class, args);
    }
}
