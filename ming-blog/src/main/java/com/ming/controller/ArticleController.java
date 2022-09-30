package com.ming.controller;

import com.ming.dao.ResponseResult;
import com.ming.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/article")
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
}
