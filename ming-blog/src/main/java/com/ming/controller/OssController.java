package com.ming.controller;


import com.ming.dao.ResponseResult;
import com.ming.service.OssService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@CrossOrigin
public class OssController {
    @Resource
    private OssService ossService;

    //1.文件上传
    @PostMapping("/upload")
    public ResponseResult uploadFile(MultipartFile img) throws IOException {
        return ossService.uploadFile(img);
    }

}
