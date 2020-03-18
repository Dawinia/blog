package com.blog.blog.mapper;

import com.blog.blog.model.entity.Article;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Dawinia Lo
 */
@Mapper
public interface ArticleMapper
{

    List<Article> getAllArticlesByPage(int page, int size, Article article);

    List<Article> getAllArticlesForUserByPage(@Param("page") int page, @Param("size") int size,
            @Param("article") Article article, @Param("uid") int uid);

    Long getTotal(Integer uid);

    int addArticle(Article article);

    int updateArticle(Article article);

    int deleteArticleById(int id);

    int deleteAllArticleForUser(int uid);
}
