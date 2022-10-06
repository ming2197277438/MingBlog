package com.ming.controller;

import com.ming.dao.ResponseResult;
import com.ming.dao.entity.User;
import com.ming.service.BlogLoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录
 */
@RestController
public class BlogLoginController {

    @Resource
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
       return blogLoginService.login(user);
    }
}
