package com.blog.blog.service.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blog.mapper.ArticleMapper;
import com.blog.blog.model.entity.Article;
import com.blog.blog.service.ArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dawinia Lo
 */
@Service
public class ArticleServiceImpl implements ArticleService
{
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Page<Article> getAllArticlesByPage(int page, int size, Article article)
    {
        page = (page - 1) * size;
        Page<Article> articlePage = new Page<>(page, size);
        List<Article> articles = articleMapper.getAllArticlesByPage(page, size, article);
        if (articles.isEmpty())
        {
            return null;
        }
        articlePage.setRecords(articles);
        articlePage.setTotal(articleMapper.getTotal(null));
        return articlePage;
    }
    @Override
    public Page<Article> getAllArticlesForUserByPage(int page, int size, Article article, int uid)
    {
        page = (page - 1) * size;
        Page<Article> articlePage = new Page<>(page, size);
        List<Article> articles = articleMapper.getAllArticlesForUserByPage(page, size, article, uid);
        if (articles.isEmpty())
        {
            return null;
        }
        articlePage.setRecords(articles);
        articlePage.setTotal(articleMapper.getTotal(uid));
        return articlePage;
    }

    @Override
    public int addArticle(Article article)
    {
        return articleMapper.addArticle(article);
    }

    @Override
    public int updateArticle(Article article)
    {
        return articleMapper.updateArticle(article);
    }

    @Override
    public int deleteArticleById(int id)
    {
        return articleMapper.deleteArticleById(id);
    }

    @Override
    public int deleteAllArticleForUser(int uid)
    {
        return articleMapper.deleteAllArticleForUser(uid);
    }
}
