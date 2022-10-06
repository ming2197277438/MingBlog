package com.ming.service;

import com.ming.dao.ResponseResult;
import com.ming.dao.entity.User;

public interface BlogLoginService {
    /**
     * 登录
     * @param user
     * @return
     */
    ResponseResult login(User user);
}
