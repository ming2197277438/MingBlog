package com.ming.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.dao.entity.MingTag;
import com.ming.mapper.MingTagMapper;
import com.ming.service.MingTagService;
import org.springframework.stereotype.Service;

/**
 * 标签(MingTag)表服务实现类
 *
 * @author makejava
 * @since 2022-10-02 13:54:50
 */
@Service("mingTagService")
public class MingTagServiceImpl extends ServiceImpl<MingTagMapper, MingTag> implements MingTagService {

}

