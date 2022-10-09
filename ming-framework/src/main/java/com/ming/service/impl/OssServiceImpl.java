package com.ming.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.ming.dao.ResponseResult;
import com.ming.e.SystemException;
import com.ming.enums.AppHttpCodeEnum;
import com.ming.service.OssService;
import com.ming.utils.PathUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: ming
 * @Date: 2022/10/09/21:34
 * @Description:
 */
@Service
@Data
@ConfigurationProperties(prefix = "oss")
public class OssServiceImpl implements OssService {
    @Override
    public ResponseResult uploadFile(MultipartFile img) throws IOException{
        //判断文件类型
        //获取原始文件名
        String originalFilename = img.getOriginalFilename();
        //对原始文件名进行判断
       /* if(!originalFilename.endsWith(".png")){
            throw new SystemException(AppHttpCodeEnum.FILE_TYPE_ERROR);
        }*/

        //如果判断通过上传文件到OSS
        String filePath = PathUtils.generateFilePath(originalFilename);
//        String url = uploadOss(img,filePath);//七牛云  2099/2/3/wqeqeqe.png
        String url = uploadFile(filePath,img.getInputStream());//七牛云  2099/2/3/wqeqeqe.png


        return ResponseResult.okResult(url);
    }

    private String endpoint ;
    private String accessKeyId ;
    private String accessKeySecret;
    private String bucketName ;

    private String uploadFile(String filePath, InputStream inputStream) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 创建PutObjectRequest对象。
        // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filePath, inputStream);

        // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
        // ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);
        // 上传字符串。
        PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();
        return "https://"+bucketName+"."+endpoint+"/"+filePath;
    }
}
