package com.ming.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ming.constants.SystemConstants;
import com.ming.dao.ResponseResult;
import com.ming.dao.entity.Article;
import com.ming.dao.entity.Category;
import com.ming.dao.vo.ArticleDetailVo;
import com.ming.dao.vo.ArticleListVo;
import com.ming.dao.vo.HotArticleVo;
import com.ming.dao.vo.PageVO;
import com.ming.mapper.ArticleMapper;
import com.ming.service.ArticleService;
import com.ming.service.CategoryService;
import com.ming.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.ming.constants.SystemConstants.ARTICLE_STATUS_NORMAL;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Resource
    private CategoryService categoryService;

    /**
     * 查询热门文章
     * @return
     */
    @Override
    public ResponseResult hotArticleList() {
        //查询热门文章
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //前10条
        Page<Article> page = new Page<>(1,10);
        page(page,queryWrapper);
        List<Article> articles = page.getRecords();
        //Bean拷贝
        List<HotArticleVo> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVo.class);
        return ResponseResult.okResult(articleVos);
    }

    /**
     * 文章列表
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @return
     */
    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        //查询条件
        LambdaQueryWrapper<Article> queryWrap =new LambdaQueryWrapper<>();
        //如果有categoryId就需要查询时和传入的相同
        queryWrap.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);
        //状态为正式发布的
        queryWrap.eq(Article::getStatus, ARTICLE_STATUS_NORMAL);
        //对is_Top进行降序
        queryWrap.orderByDesc(Article::getIsTop);
        //分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page,queryWrap);
        List<Article> articles = page.getRecords();
        //查询categoryName
          articles.stream()
                .map(article -> article.setCategoryName
                        (categoryService.getById(article.getCategoryId()).getName()))
                .collect(Collectors.toList());
        //封装查询结果
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);
        PageVO pageVO = new PageVO(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVO);
    }

    /**
     * 文章详情
     * @param id
     * @return
     */
    @Override
    public ResponseResult getArticleDetail(Long id) {
        //根据id查询文章
        Article article = getById(id);
        //转换VO
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);
        //根据分类id查询分类名
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        if (category != null) {
            articleDetailVo.setCategoryName(category.getName());
        }
        //封装响应
        return ResponseResult.okResult(articleDetailVo);
    }
}
