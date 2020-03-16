package com.blog.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blog.api.Result;
import com.blog.blog.model.entity.User;
import com.blog.blog.service.UserService;
import com.blog.blog.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Result getAllUsers()
    {
        return ResultUtil.success(userService.getAllUsers());
    }

    @GetMapping("/")
    public Result getUsersByPage(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size, User user)
    {
        Page<User> userPage = new Page<>(page, size);
        userPage.setRecords(userService.getUsersByPage(page, size, user));
        return ResultUtil.success(userPage);
    }

    @GetMapping("/{id}")
    public Result getUserById(@PathVariable int id)
    {
        User user = userService.getUserById(id);
        return user == null ? ResultUtil.error("暂无该用户信息")
                : ResultUtil.success(user);
    }

    @DeleteMapping("/{id}")
    public Result deleteUserById(@PathVariable int id)
    {
        return userService.deleteUserById(id) == 1 ? ResultUtil.success()
                : ResultUtil.error("删除失败");
    }

    @PutMapping("/")
    public Result updateUser(@RequestBody User user)
    {
        return userService.updateUser(user) == 1 ? ResultUtil.success()
                : ResultUtil.error("更新失败");
    }

    @PostMapping("/")
    public Result addUser(@RequestBody User user)
    {
        return userService.addUser(user) == 1 ? ResultUtil.success()
                : ResultUtil.error("添加失败");
    }

}
