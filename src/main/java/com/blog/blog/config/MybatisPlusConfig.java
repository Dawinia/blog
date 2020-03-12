package com.blog.blog.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Dawinia Lo
 */
@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig
{
    /**
     *  分页
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     **/
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
