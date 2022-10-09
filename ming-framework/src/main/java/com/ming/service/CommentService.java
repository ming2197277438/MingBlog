package com.ming.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ming.dao.ResponseResult;
import com.ming.dao.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2022-10-02 13:46:59
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}

