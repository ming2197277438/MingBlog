package com.ming.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.dao.entity.Link;
import com.ming.mapper.LinkMapper;
import com.ming.service.LinkService;
import org.springframework.stereotype.Service;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2022-10-02 13:47:20
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

}

