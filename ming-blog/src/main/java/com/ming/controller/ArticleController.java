package com.ming.controller;

import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.ming.dao.ResponseResult;
import com.ming.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 热门数据
 */
@CrossOrigin
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

    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum,
                                      Integer pageSize,
                                      Long categoryId){
        return articleService.articleList(pageNum,pageSize,categoryId);
    }

    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id){
        return articleService.getArticleDetail(id);
    }
}
