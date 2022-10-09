package com.ming.dao.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author: ming
 * @Date: 2022/10/08/19:34
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVo {
    @TableId
    private Long id;
    //文章id
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userId
    private Long toCommentUserId;
    //所回复的目标评论的userName
    private String toCommentUserName;
    //回复目标评论id
    private Long toCommentId;

    private Long createBy;

    private Date createTime;

    private String username;

    private List<CommentVo> children;
}
