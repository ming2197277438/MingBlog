package com.ming.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.constants.SystemConstants;
import com.ming.dao.ResponseResult;
import com.ming.dao.entity.Comment;
import com.ming.dao.vo.CommentVo;
import com.ming.dao.vo.PageVO;
import com.ming.mapper.CommentMapper;
import com.ming.service.CommentService;
import com.ming.service.UserService;
import com.ming.utils.BeanCopyUtils;
import com.ming.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author makejava
 * @since 2022-10-02 13:46:59
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    private UserService userService;



    @Override
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize) {
        //查询对应文章的根评论
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        //对articleId进行判断
        queryWrapper.eq(Comment::getArticleId,articleId);
        //跟评论rootId为-1
        queryWrapper.eq(Comment::getRootId, SystemConstants.COMMENT_ROOT_ID);
        //分页查询
        Page<Comment> page = new Page<>(pageNum,pageSize);
        page(page,queryWrapper);
        List<CommentVo> commentVoList = toCommentVoList(page.getRecords());
        //查询所有跟评论对应的子评论集合，并且赋值给对应的属性
        for (CommentVo commentVo : commentVoList) {
            //查询对应的子评论
           List<CommentVo> children = getChildren(commentVo.getId());
           //赋值
            commentVo.setChildren(children);
        }
        return ResponseResult.okResult(new PageVO(commentVoList,page.getTotal()));
    }


    @Override
    public ResponseResult addComment(Comment comment) {
        //获取当前用户id
        comment.setCreateBy(SecurityUtils.getUserId());
        save(comment);
        return ResponseResult.okResult();
    }
    /**
     * 根据跟评论的id查询所对应的子评论的集合
     * @param id
     * @return
     */
    private List<CommentVo> getChildren(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getRootId, id);
        queryWrapper.orderByAsc(Comment::getCreateTime);
        List<Comment> commentList = list(queryWrapper);
        List<CommentVo> commentVos = toCommentVoList(commentList);
        return commentVos;
    }


    private List<CommentVo> toCommentVoList(List<Comment> list){
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(list, CommentVo.class);
        //遍历vo集合
        //通过creatyBy查询用户的昵称并赋值
        //通过toCommentUserId查询用户的昵称并赋值
        //如果toCommentUserId不为-1才进行查询
        commentVos.stream().forEach(commentVo -> {
            commentVo.setUsername(userService.getById(commentVo.getCreateBy()).getNickName());
            if (commentVo.getToCommentUserId() != SystemConstants.COMMENT_ROOT_ID) {
                commentVo.setToCommentUserName(userService.getById(commentVo.getToCommentUserId()).getNickName());
            }
        });
        return commentVos;
    }
}

