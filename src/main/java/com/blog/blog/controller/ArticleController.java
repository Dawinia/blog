package com.blog.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blog.api.Result;
import com.blog.blog.model.entity.Article;
import com.blog.blog.service.ArticleService;
import com.blog.blog.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dawinia Lo
 */
@RestController
@RequestMapping("/article")
public class ArticleController
{

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public Result getAllArticlesByPage(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size, Article article)
    {
        Page<Article> articlePage = articleService.getAllArticlesByPage(page, size, article);
        return articlePage == null ? ResultUtil.error("暂无该文章信息") : ResultUtil.success(articlePage);
    }

    @GetMapping("/{uid}")
    public Result getAllArticlesForUserByPage(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size, Article article, @PathVariable int uid)
    {
        Page<Article> articlePage = articleService
                .getAllArticlesForUserByPage(page, size, article, uid);
        return articlePage == null ? ResultUtil.error("该用户暂无文章") : ResultUtil.success(articlePage);
    }

    @PostMapping("/")
    public Result addArticle(@RequestBody Article article)
    {
        return articleService.addArticle(article) == 1 ? ResultUtil.success()
                : ResultUtil.error("添加失败");
    }

    @PutMapping("/")
    public Result updateArticle(@RequestBody Article article)
    {
        return articleService.updateArticle(article) == 1 ? ResultUtil.success()
                : ResultUtil.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public Result deleteArticleById(@PathVariable int id)
    {
        return articleService.deleteArticleById(id) == 1 ? ResultUtil.success()
                : ResultUtil.error("删除失败");
    }

    @DeleteMapping("/all/{uid}")
    public Result deleteAllArticleForUser(@PathVariable int uid)
    {
        return articleService.deleteAllArticleForUser(uid) == 1 ? ResultUtil.success()
                : ResultUtil.error("删除失败");
    }
}
