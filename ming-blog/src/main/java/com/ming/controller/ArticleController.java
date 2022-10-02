package com.ming.controller;

import com.ming.dao.ResponseResult;
import com.ming.service.ArticleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 热门数据
 */
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    @Resource
    private ArticleService articleService;

    /*@GetMapping("/list")
    public List<Article> demo(){
        return articleService.list();
    }*/

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList() {
        //查询热门文章
        return articleService.hotArticleList();
    }

    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum,
                                      Integer pageSize,
                                      Long categoryId){
        return articleService.articleList(pageNum,pageSize,categoryId);
    }
}
