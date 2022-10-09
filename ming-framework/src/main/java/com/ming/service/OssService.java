package com.ming.service;

import com.ming.dao.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: ming
 * @Date: 2022/10/09/21:33
 * @Description:
 */
public interface OssService {
    ResponseResult uploadFile(MultipartFile img) throws IOException;
}
