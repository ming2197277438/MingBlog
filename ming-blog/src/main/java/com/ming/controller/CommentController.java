package com.ming.controller;

import com.ming.dao.ResponseResult;
import com.ming.dao.entity.Comment;
import com.ming.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: ming
 * @Date: 2022/10/08/19:13
 * @Description:
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("/commentList")
    public ResponseResult commentList(Long articleId, Integer pageNum,Integer pageSize) {
        return commentService.commentList(articleId,pageNum,pageSize);
    }
    @PostMapping
    public ResponseResult addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }
}
