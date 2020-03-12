package com.blog.blog.controller;

import com.blog.blog.api.Result;
import com.blog.blog.model.entity.User;
import com.blog.blog.service.UserService;
import com.blog.blog.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Result getAllUser() {
        return ResultUtil.success(userService.getAllUser());
//        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public int deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

    @PutMapping("/")
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/")
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

}
