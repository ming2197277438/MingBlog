package com.ming.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ming.dao.ResponseResult;
import com.ming.dao.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-10-02 13:41:40
 */
public interface CategoryService extends IService<Category> {

    /**
     * 查询分类信息
     * @return
     */
    ResponseResult getCategoryList();
}

