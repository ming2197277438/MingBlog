package com.ming.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ming.dao.ResponseResult;
import com.ming.dao.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-10-02 13:47:20
 */
public interface LinkService extends IService<Link> {

    /**
     * 友链
     * @return
     */
    ResponseResult getAllLink();
}

