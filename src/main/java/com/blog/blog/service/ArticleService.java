package com.blog.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blog.model.entity.Article;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Dawinia Lo
 */
@Service
public interface ArticleService
{
    Page<Article> getAllArticlesByPage(int page, int size, Article article);

    Page<Article> getAllArticlesForUserByPage(int page, int size, Article article, int uid);

    int addArticle(Article article);

    int updateArticle(Article article);

    int deleteArticleById(int id);

    int deleteAllArticleForUser(int uid);
}
