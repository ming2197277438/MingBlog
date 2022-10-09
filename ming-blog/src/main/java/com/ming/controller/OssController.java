package com.ming.controller;


import com.ming.dao.ResponseResult;
import com.ming.service.OssService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class OssController {
    @Resource
    private OssService ossService;

    //1.文件上传
    @PostMapping("/upload")
    public ResponseResult uploadFile(MultipartFile file) throws Exception {
        return ossService.uploadFile(file);
    }
   /* //2.删除单个文件
    @DeleteMapping("deleteSingleFile")
    public ResponseResult deleteSingleFile(String fileName) {
        boolean flag=ossService.deleteSingleFile(fileName);
        if(flag){
            return RetVal.success();
        }else{
            return RetVal.error();
        }
    }*/
   /* //3.删除多个文件
    @DeleteMapping("deleteMultiFile")
    public ResponseResult deleteMultiFile(List<String>fileNameList) {
        boolean flag=ossService.deleteMultiFile(fileNameList);
        if(flag){
            return ResponseResult.okResult();
        }else{
            return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
        }
    }*/
}
