package com.ming;


import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ming.mapper")
public class MingBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(MingBlogApplication.class, args);
    }
}
