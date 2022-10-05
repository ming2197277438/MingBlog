package com.ming.controller;

import com.ming.dao.ResponseResult;
import com.ming.service.LinkService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 友连
 */
@RestController
@RequestMapping("/link")
@CrossOrigin
public class LinkController {

    @Resource
    private LinkService linkService;

    @GetMapping("/getAllLink")
    public ResponseResult getAllLink(){
        return linkService.getAllLink();
    }
}
