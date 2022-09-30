package com.ming.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ming.dao.ResponseResult;
import com.ming.dao.entity.Article;

public interface ArticleService extends IService<Article> {
    /**
     * 查询热门文章
     * @return
     */
    ResponseResult hotArticleList();
}
