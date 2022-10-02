package com.ming.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.dao.entity.Category;
import com.ming.mapper.CategoryMapper;
import com.ming.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2022-10-02 13:41:41
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


}

