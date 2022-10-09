package com.ming;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author: ming
 * @Date: 2022/10/09/20:18
 * @Description:
 */
@SpringBootTest
public class ossTest {
    @Test
    public void testOss() throws Exception{
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tR47yXPpMoPpwoDN8LD";
        String accessKeySecret = "P23xOdzFWuQhqdIb3cVDu0ah2xVPKV";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "mingblog2020";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        InputStream inputStream = new FileInputStream("D:\\壁纸\\headbg05.jpg");
        // 创建PutObject请求。
        ossClient.putObject(bucketName, "new.jpg", inputStream);
        ossClient.shutdown();
    }

    @Test
    public void testOssd() throws Exception{
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tR47yXPpMoPpwoDN8LD";
        String accessKeySecret = "P23xOdzFWuQhqdIb3cVDu0ah2xVPKV";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "mingblog2020";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        InputStream inputStream = new FileInputStream("D:\\壁纸\\headbg05.jpg");
        // 创建PutObject请求。
        ossClient.putObject(bucketName, "new.jpg", inputStream);

        // 删除文件或目录。如果要删除目录，目录必须为空。
        ossClient.deleteObject(bucketName, "new.jpg");
        ossClient.shutdown();
    }
}
