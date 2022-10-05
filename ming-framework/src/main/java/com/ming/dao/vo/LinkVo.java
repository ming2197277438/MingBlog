package com.ming.dao.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkVo {
    @TableId
    private Long id;

    private String name;

    private String logo;

    //网站地址
    private String address;

    //描述
    private String description;

}
